package com.congcoi123.example.backend

import com.congcoi123.example.backend.skill.*
import io.grpc.ManagedChannelBuilder
import io.reactivex.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.lognet.springboot.grpc.autoconfigure.GRpcServerProperties
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

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
		val channel = ManagedChannelBuilder.forAddress("127.0.0.1", gRpcProperties.port)
			.usePlaintext()
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
		val expectedResult = CastedSkill.newBuilder().setEffective(true).build()

		caster.castSkill(request)
			.map(CastSkillRequestResponse::getResult)
			.test()
			.await()
			.assertValue(expectedResult)
	}

}
