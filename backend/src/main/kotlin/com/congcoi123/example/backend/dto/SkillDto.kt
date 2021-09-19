package com.congcoi123.example.backend.dto

import com.congcoi123.example.backend.enum.SkillType

data class SkillDto (
    val skillId: Long?,
    val type: SkillType,
    val name: String,
    val damage: Int
)

data class CastedSkillDto (
    val skillDto: SkillDto,
    val effective: Boolean
)
