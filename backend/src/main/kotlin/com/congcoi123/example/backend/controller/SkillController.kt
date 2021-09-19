package com.congcoi123.example.backend.controller

import com.congcoi123.example.backend.converter.CastedSkillConverter
import com.congcoi123.example.backend.dto.SkillDto
import com.congcoi123.example.backend.enum.SkillType
import com.congcoi123.example.backend.proto.skill.CastedSkill
import com.congcoi123.example.backend.service.SkillService
import io.reactivex.Single
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SkillController(
    private val skillService: SkillService
) {

    @GetMapping(
        value = ["/castskill"],
        produces = [MediaType.TEXT_EVENT_STREAM_VALUE]
    )
    suspend fun castSkill(
        @RequestParam("name") name: String,
        @RequestParam("type") type: Int,
        @RequestParam("damage") damage: Int
    ): Single<CastedSkill> {
        val skillDto = SkillDto(skillId = null, name = name, type = SkillType.fromInt(type), damage = damage)
        return skillService.castSkill(Single.just(skillDto)).map { CastedSkillConverter.reverse().convert(it) }
    }
}
