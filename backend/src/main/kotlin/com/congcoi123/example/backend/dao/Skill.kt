package com.congcoi123.example.backend.dao

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("skill")
data class Skill(
    @Id
    @Column("skill_id")
    val skillId: Long? = null,
    @Column("type")
    val type: Int = 0,
    @Column("name")
    val name: String = "",
    @Column("damage")
    val damage: Int = 0,
    @Column("effective")
    val effective: Boolean? = null
)
