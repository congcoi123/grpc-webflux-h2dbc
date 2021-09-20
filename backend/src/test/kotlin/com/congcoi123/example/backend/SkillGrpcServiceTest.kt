package com.congcoi123.example.backend

import com.congcoi123.example.backend.proto.skill.CastSkillRequest
import com.congcoi123.example.backend.proto.skill.RxSkillAPIGrpc
import com.congcoi123.example.backend.proto.skill.Skill
import com.congcoi123.example.backend.proto.skill.SkillType
import io.grpc.netty.NettyChannelBuilder
import io.reactivex.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.lognet.springboot.grpc.autoconfigure.GRpcServerProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("test")
class SkillGrpcServiceTest(
    @Autowired private val gRpcProperties: GRpcServerProperties
) {

    private lateinit var caster: RxSkillAPIGrpc.RxSkillAPIStub

    @BeforeEach
    fun setup() {
        val channel = NettyChannelBuilder.forAddress("localhost", gRpcProperties.port)
            .usePlaintext()
//            .negotiationType(NegotiationType.TLS)
//            .sslContext(
//                GrpcSslContexts.configure(
//                    SslContextBuilder.forClient(),
//                    SslProvider.OPENSSL
//                ).trustManager(InsecureTrustManagerFactory.INSTANCE).build()
//            )
            .build()

        caster = RxSkillAPIGrpc.newRxStub(channel)
    }

    @Test
    fun castSkillShouldReturnResult() {
        val skillProto = Skill.newBuilder()
            .setType(SkillType.SKILL_TYPE_FIRE)
            .setName("Boiling Point")
            .setDamage(30)
            .build()

        val request = Single.just(CastSkillRequest.newBuilder().setSkill(skillProto).build())
        val result = caster.castSkill(request)
            .map { it ->
                it.castedSkill
            }
            .blockingGet() as Skill

        assertAll({
            assert(skillProto.name == result.name)
            assert(skillProto.type == result.type)
            assert(skillProto.damage == result.damage)
        })
    }
}
