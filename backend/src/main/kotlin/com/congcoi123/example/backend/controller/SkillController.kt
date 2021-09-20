package com.congcoi123.example.backend.controller

import com.congcoi123.example.backend.dao.Skill
import com.congcoi123.example.backend.dto.SkillDto
import com.congcoi123.example.backend.enum.SkillType
import com.congcoi123.example.backend.model.SkillModel
import com.congcoi123.example.backend.service.SkillService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class SkillController(
    @Autowired private val skillService: SkillService
) {

    private val logger: Logger = LoggerFactory.getLogger(SkillController::class.java)

    @PostMapping(
        value = ["/castskill"]
    )
    suspend fun castSkill(
        @RequestBody skillModel: SkillModel
    ): Mono<Skill> {
        logger.warn("BODY: ${skillModel.toString()}")

        return skillService.castSkill(
            SkillDto(
                name = skillModel.name,
                type = SkillType.fromInt(skillModel.type),
                damage = skillModel.damage
            )
        )
            .doOnNext {
                logger.warn("DTO: ${it.toString()}")
            }
            .map { skillDto ->
            Skill(skillDto.skillId, skillDto.type.value, skillDto.name, skillDto.damage, skillDto.effective)
        }
    }
}
