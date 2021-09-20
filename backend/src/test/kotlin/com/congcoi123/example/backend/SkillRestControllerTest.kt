/**
The MIT License

Copyright (c) 2021 kong <congcoi123@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.congcoi123.example.backend

import com.congcoi123.example.backend.dao.Skill
import com.congcoi123.example.backend.enum.SkillType
import com.congcoi123.example.backend.model.SkillModel
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
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
            .blockFirst() as Skill

        assertAll({
            assert(skillModel.name == result.name)
            assert(skillModel.type == result.type)
            assert(skillModel.damage == result.damage)
        })
    }
}
