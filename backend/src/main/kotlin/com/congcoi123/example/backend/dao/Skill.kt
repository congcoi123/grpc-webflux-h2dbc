package com.congcoi123.example.backend.dao

import com.congcoi123.example.backend.enum.SkillType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("skill")
data class Skill(
    @Id
    @Column("skill_id")
    val skillId: Long?,
    @Column("type")
    val type: SkillType,
    @Column("name")
    val name: String,
    @Column("damage")
    val damage: Int
)
