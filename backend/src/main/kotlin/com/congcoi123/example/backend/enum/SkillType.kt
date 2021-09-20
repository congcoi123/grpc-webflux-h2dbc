package com.congcoi123.example.backend.enum

enum class SkillType(
    val value: Int
) {
    SKILL_TYPE_NONE(value = 0),
    SKILL_TYPE_UNKNOWN(value = 1),
    SKILL_TYPE_SUMMON(value = 2),
    SKILL_TYPE_FIRE(value = 3),
    SKILL_TYPE_WATER(value = 4),
    SKILL_TYPE_WIND(value = 5),
    SKILL_TYPE_THUNDER(value = 6),
    SKILL_TYPE_ROCK(value = 7),
    SKILL_TYPE_WOOD(value = 8);

    companion object {
        fun fromInt(value: Int) = SkillType.values().first { it.value == value }
    }
}
