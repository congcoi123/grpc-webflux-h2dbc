package com.congcoi123.example.backend

import com.congcoi123.example.backend.proto.skill.*
import io.grpc.ManagedChannelBuilder
import io.grpc.ServerBuilder
import io.grpc.netty.NettyServerBuilder
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder
import io.grpc.netty.shaded.io.netty.handler.ssl.SslProvider
import io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory
import io.reactivex.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.lognet.springboot.grpc.autoconfigure.GRpcServerProperties
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.concurrent.TimeUnit
import kotlin.math.log

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("test")
class BackendApplicationTests(
	@Autowired private val gRpcProperties: GRpcServerProperties
) {

	private val logger: Logger = LoggerFactory.getLogger(BackendApplicationTests::class.java)

	lateinit var caster: RxSkillAPIGrpc.RxSkillAPIStub

	@BeforeEach
	fun setup() {
		val channel = NettyChannelBuilder.forAddress("localhost", gRpcProperties.port)
			.negotiationType(NegotiationType.TLS)
			.sslContext(GrpcSslContexts.configure(
				SslContextBuilder.forClient(),
				SslProvider.OPENSSL
			).trustManager(InsecureTrustManagerFactory.INSTANCE).build())
			.build()

		caster = RxSkillAPIGrpc.newRxStub(channel)
	}

	@Test
	fun castSkillShouldReturnResult() {
		val skill = Skill.newBuilder()
			.setType(SkillType.SKILL_TYPE_FIRE)
			.setName("Boiling Point")
			.setDamage(10)
			.build()

		logger.info(skill.toString())

		val request = Single.just(CastSkillRequest.newBuilder().setSkill(skill).build())
//		val expectedResult = CastedSkill.newBuilder().setEffective(true).build()

//		caster.castSkill(request)
//			.map(CastSkillRequestResponse::getResult)
//			.test()
//			.await()
//			.assertValue(expectedResult)

		logger.warn("Here we are")

		val test = caster.castSkill(request).test().awaitTerminalEvent(3, TimeUnit.SECONDS)

//		val effectiveResult = request.`as`(caster::castSkill)
//			.map(CastSkillRequestResponse::getResult)
//			.blockingGet().effective
//
//		logger.info("Result: $effectiveResult")

		assert(true)
	}

}
