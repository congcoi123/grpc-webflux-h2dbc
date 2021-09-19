package com.congcoi123.example.backend

import com.congcoi123.example.backend.proto.skill.Skill
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.reactive.function.client.WebClient

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
        webClient = WebClient
            .builder()
            .baseUrl("http://localhost:${serverProperties.port}")
            .build()
    }

    @Test
    fun castSkillShouldReturnResult() {
        val result = webClient.get()
            .uri("/castskill")
            .accept(MediaType.TEXT_EVENT_STREAM)
            .attribute("name", "Boiling Point")
            .attribute("type", 3)
            .attribute("damage", 10)
            .retrieve()
            .bodyToMono(Skill::class.java)
            .map { logger.warn(it.toString()) }
            .block()

        logger.warn(result.toString())

        assert(true)
    }
}
