package com.congcoi123.example.backend.dao

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("skill")
data class Skill(
    @Id
    @Column("skill_id")
    val skillId: Long?,
    @Column("type")
    val type: Int,
    @Column("name")
    val name: String,
    @Column("damage")
    val damage: Int
)
