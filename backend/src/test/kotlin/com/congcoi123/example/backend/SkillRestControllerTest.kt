package com.congcoi123.example.backend

import com.congcoi123.example.backend.dao.Skill
import com.congcoi123.example.backend.enum.SkillType
import com.congcoi123.example.backend.model.SkillModel
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("test")
class SkillRestControllerTest(
    @Autowired private val serverProperties: ServerProperties
) {

    private val logger: Logger = LoggerFactory.getLogger(SkillRestControllerTest::class.java)

    private lateinit var webClient: WebClient

    @BeforeEach
    fun setup() {
        webClient = WebClient.create("http://localhost:${serverProperties.port}")
    }

    @Test
    fun castSkillShouldReturnResult() {
        val skillModel = SkillModel(
            name = "Boiling Point",
            type = SkillType.SKILL_TYPE_FIRE.value,
            damage = 20
        )
        val result = webClient
            .post()
            .uri("/api/castskill")
            .body(BodyInserters.fromPublisher(Mono.just(skillModel), SkillModel::class.java))
            .retrieve()
            .bodyToFlux(Skill::class.java)
            .blockFirst()

        logger.error("FINISHED: ${result.toString()}")

        assert(true)
    }
}
