package com.congcoi123.example.backend.controller

import com.congcoi123.example.backend.dao.Skill
import com.congcoi123.example.backend.dto.SkillDto
import com.congcoi123.example.backend.enum.SkillType
import com.congcoi123.example.backend.model.SkillModel
import com.congcoi123.example.backend.service.SkillService
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

    @PostMapping(
        value = ["/castskill"]
    )
    fun castSkill(
        @RequestBody skillModel: SkillModel
    ): Mono<Skill> = skillService.castSkill(
        SkillDto(
            name = skillModel.name,
            type = SkillType.fromInt(skillModel.type),
            damage = skillModel.damage
        )
    ).map { skillDto ->
        Skill(skillDto.skillId, skillDto.type.value, skillDto.name, skillDto.damage, skillDto.effective)
    }
}
