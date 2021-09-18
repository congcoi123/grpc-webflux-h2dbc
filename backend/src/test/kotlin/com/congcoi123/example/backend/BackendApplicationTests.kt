package com.congcoi123.example.backend

import com.congcoi123.example.backend.skill.*
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder
import io.reactivex.Single
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.lognet.springboot.grpc.autoconfigure.GRpcServerProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("test")
class BackendApplicationTests(
	@Autowired private val gRpcProperties: GRpcServerProperties,
	private var castSkill: RxSkillAPIGrpc.RxSkillAPIStub
) {

	@BeforeEach
	fun setup() {
		val channel = NettyChannelBuilder.forAddress("127.0.0.1", gRpcProperties.port)
			.build()
		castSkill = RxSkillAPIGrpc.newRxStub(channel)
	}

	@Test
	fun castSkillShouldReturnResult() {
		val skill = Skill.newBuilder()
			.setType(SkillType.SKILL_TYPE_FIRE)
			.setName("Boiling Point")
			.setDamage(10)
			.build()

		val request = Single.just(CastSkillRequest.newBuilder().setSkill(skill).build())

		request.`as`(castSkill::castSkill)
			.map(CastSkillRequestResponse::getResult)
			.subscribe{
				it -> Assertions.assertTrue(it.effective)
			}
	}

}
