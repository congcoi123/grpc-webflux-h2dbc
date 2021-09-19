package com.congcoi123.example.backend.enum

enum class SkillType(
    val value: Int
) {
    SKILL_TYPE_NONE(0),
    SKILL_TYPE_UNKNOWN(1),
    SKILL_TYPE_SUMMON(2),
    SKILL_TYPE_FIRE(3),
    SKILL_TYPE_WATER(4),
    SKILL_TYPE_WIND(5),
    SKILL_TYPE_THUNDER(6),
    SKILL_TYPE_ROCK(7),
    SKILL_TYPE_WOOD(8);

    companion object {
        fun fromInt(value: Int) = SkillType.values().first { it.value == value }
    }
}
