package com.congcoi123.example.backend.converter

import com.congcoi123.example.backend.enum.SkillType as EnumSkillType
import com.congcoi123.example.backend.proto.skill.SkillType as ProtoSkillType
import com.google.common.base.Converter

object SkillTypeConverter : Converter<ProtoSkillType, EnumSkillType>() {
    override fun doForward(a: ProtoSkillType): EnumSkillType =
        when(a) {
            ProtoSkillType.SKILL_TYPE_NONE -> EnumSkillType.SKILL_TYPE_NONE
            ProtoSkillType.SKILL_TYPE_UNKNOWN -> EnumSkillType.SKILL_TYPE_UNKNOWN
            ProtoSkillType.SKILL_TYPE_SUMMON -> EnumSkillType.SKILL_TYPE_SUMMON
            ProtoSkillType.SKILL_TYPE_FIRE -> EnumSkillType.SKILL_TYPE_FIRE
            ProtoSkillType.SKILL_TYPE_WATER -> EnumSkillType.SKILL_TYPE_WATER
            ProtoSkillType.SKILL_TYPE_WIND -> EnumSkillType.SKILL_TYPE_WIND
            ProtoSkillType.SKILL_TYPE_THUNDER -> EnumSkillType.SKILL_TYPE_THUNDER
            ProtoSkillType.SKILL_TYPE_ROCK -> EnumSkillType.SKILL_TYPE_ROCK
            ProtoSkillType.SKILL_TYPE_WOOD -> EnumSkillType.SKILL_TYPE_WOOD
            else -> throw NotImplementedError()
        }

    override fun doBackward(b: EnumSkillType): ProtoSkillType =
        when(b) {
            EnumSkillType.SKILL_TYPE_NONE -> ProtoSkillType.SKILL_TYPE_NONE
            EnumSkillType.SKILL_TYPE_UNKNOWN -> ProtoSkillType.SKILL_TYPE_UNKNOWN
            EnumSkillType.SKILL_TYPE_SUMMON -> ProtoSkillType.SKILL_TYPE_SUMMON
            EnumSkillType.SKILL_TYPE_FIRE -> ProtoSkillType.SKILL_TYPE_FIRE
            EnumSkillType.SKILL_TYPE_WATER -> ProtoSkillType.SKILL_TYPE_WATER
            EnumSkillType.SKILL_TYPE_WIND -> ProtoSkillType.SKILL_TYPE_WIND
            EnumSkillType.SKILL_TYPE_THUNDER -> ProtoSkillType.SKILL_TYPE_THUNDER
            EnumSkillType.SKILL_TYPE_ROCK -> ProtoSkillType.SKILL_TYPE_ROCK
            EnumSkillType.SKILL_TYPE_WOOD -> ProtoSkillType.SKILL_TYPE_WOOD
        }
}