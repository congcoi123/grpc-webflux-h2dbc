package com.congcoi123.example.backend.repository

import com.congcoi123.example.backend.dao.Skill
import org.springframework.data.r2dbc.convert.MappingR2dbcConverter
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class SkillRepository(
    private val client: DatabaseClient,
    private val converter: MappingR2dbcConverter
) {

    fun getSkillById(skillId: Long): Mono<Skill> =
        client.sql("SELECT * FROM skill WHERE skill_id = $1;")
            .bind(0, skillId)
            .map { row, metadata -> converter.read(Skill::class.java, row, metadata) }
            .one()

    fun createNewCastedSkill(skill: Skill): Mono<Long?> =
        client.sql("INSERT INTO skill (name, type, damage) VALUES($1, $2);")
            .bind(0, skill.name)
            .bind(1, skill.type)
            .bind(2, skill.damage)
            .map { it -> it.get("skill_id", Long::class.java) }
            .one()

    fun getAllSkills(): Flux<Skill> =
        client.sql("SELECT * FROM skill;")
            .map { row, metadata -> converter.read(Skill::class.java, row, metadata) }
            .all()
}
