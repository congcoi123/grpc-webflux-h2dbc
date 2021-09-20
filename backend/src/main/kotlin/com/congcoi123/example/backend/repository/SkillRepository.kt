/**
The MIT License

Copyright (c) 2021 kong <congcoi123@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
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

    fun createNewCastedSkill(skill: Skill): Mono<Long> =
        client.sql("INSERT INTO skill (name, type, damage) VALUES($1, $2, $3);")
            .filter { statement, _ ->
                statement.returnGeneratedValues("skill_id").execute()
            }
            .bind(0, skill.name)
            .bind(1, skill.type)
            .bind(2, skill.damage)
            .fetch()
            .first()
            .map { it -> it["skill_id"] as Long }

    fun getAllSkills(): Flux<Skill> =
        client.sql("SELECT * FROM skill;")
            .map { row, metadata -> converter.read(Skill::class.java, row, metadata) }
            .all()
}
