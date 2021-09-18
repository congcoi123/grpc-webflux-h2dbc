package com.congcoi123.example.backend.converter

import com.congcoi123.example.backend.dto.SkillDto as DtoSkill
import com.congcoi123.example.backend.proto.skill.Skill as ProtoSkill
import com.google.common.base.Converter
import java.lang.UnsupportedOperationException

object SkillConverter : Converter<ProtoSkill, DtoSkill>() {

    override fun doForward(a: ProtoSkill): DtoSkill =
        DtoSkill(
            skillId = a.skillId,
            type = SkillTypeConverter.convert(a.type)!!,
            name = a.name,
            damage = a.damage
        )

    override fun doBackward(b: DtoSkill): ProtoSkill = throw UnsupportedOperationException()
}