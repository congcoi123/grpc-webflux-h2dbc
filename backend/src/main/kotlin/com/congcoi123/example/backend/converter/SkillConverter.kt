package com.congcoi123.example.backend.converter

import com.google.common.base.Converter
import com.congcoi123.example.backend.dto.SkillDto as DtoSkill
import com.congcoi123.example.backend.proto.skill.Skill as ProtoSkill

object SkillConverter : Converter<ProtoSkill, DtoSkill>() {

    override fun doForward(a: ProtoSkill): DtoSkill =
        DtoSkill(
            skillId = a.skillId,
            type = SkillTypeConverter.convert(a.type)!!,
            name = a.name,
            damage = a.damage,
            effective = a.effective
        )

    override fun doBackward(b: DtoSkill): ProtoSkill =
        ProtoSkill.newBuilder()
            .setSkillId(b.skillId!!)
            .setType(SkillTypeConverter.reverse().convert(b.type))
            .setName(b.name)
            .setDamage(b.damage)
            .setEffective(b.effective!!)
            .build()
}
