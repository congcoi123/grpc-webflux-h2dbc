package com.congcoi123.example.backend.service

import com.congcoi123.example.backend.dao.Skill
import com.congcoi123.example.backend.dto.SkillDto
import com.congcoi123.example.backend.enum.SkillType
import com.congcoi123.example.backend.repository.SkillRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import kotlin.math.log
import kotlin.random.Random

@Service
class SkillService(
    @Autowired private val skillRepository: SkillRepository
) {

    private val logger: Logger = LoggerFactory.getLogger(SkillService::class.java)

    fun castSkill(skillDto: SkillDto): Mono<SkillDto> {
        val skill = Skill(
            type = skillDto.type.value,
            name = skillDto.name,
            damage = skillDto.damage,
            effective = Random.nextBoolean()
        )
        logger.warn("Will create: ${skill.toString()}")

        return skillRepository.createNewCastedSkill(skill)
            .doOnNext {
                logger.warn("New ID: ${it.toString()}")
            }
            .flatMap { skillId ->
                skillRepository.getSkillById(skillId!!).map { it ->
                    SkillDto(it.skillId, SkillType.fromInt(it.type), it.name, it.damage, it.effective)
                }.switchIfEmpty(Mono.empty())
            }.switchIfEmpty(Mono.empty())
    }
}
