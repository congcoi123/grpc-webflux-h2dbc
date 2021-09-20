package com.congcoi123.example.backend.dto

import com.congcoi123.example.backend.enum.SkillType

data class SkillDto (
    val skillId: Long? = null,
    val type: SkillType,
    val name: String,
    val damage: Int,
    val effective: Boolean? = null
)
