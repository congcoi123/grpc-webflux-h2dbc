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
package com.congcoi123.example.backend.service

import com.congcoi123.example.backend.dao.Skill
import com.congcoi123.example.backend.dto.SkillDto
import com.congcoi123.example.backend.enum.SkillType
import com.congcoi123.example.backend.repository.SkillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import kotlin.random.Random

@Service
class SkillService(
    @Autowired private val skillRepository: SkillRepository
) {

    fun castSkill(skillDto: SkillDto): Mono<SkillDto> {
        val skill = Skill(
            type = skillDto.type.value,
            name = skillDto.name,
            damage = skillDto.damage,
            effective = Random.nextBoolean()
        )
        return skillRepository.createNewCastedSkill(skill)
            .flatMap { skillId ->
                skillRepository.getSkillById(skillId!!).map { it ->
                    SkillDto(it.skillId, SkillType.fromInt(it.type), it.name, it.damage, it.effective)
                }
            }
    }
}
