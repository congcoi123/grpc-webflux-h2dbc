package com.congcoi123.example.backend.initializer

import com.congcoi123.example.backend.dao.Skill
import com.congcoi123.example.backend.dto.SkillDto
import com.congcoi123.example.backend.enum.SkillType
import com.congcoi123.example.backend.repository.SkillRepository
import com.congcoi123.example.backend.service.SkillService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(
    value = 2
)
@Profile(
    value = [
        "default"
    ]
)
class InternalTesting {

    private val logger: Logger = LoggerFactory.getLogger(InternalTesting::class.java)

    @Bean
    fun runnerTesting(skillRepository: SkillRepository, skillService: SkillService) =
        ApplicationRunner {
            // testing database
            skillRepository.createNewCastedSkill(
                Skill(
                    name = "Test",
                    type = SkillType.SKILL_TYPE_UNKNOWN.value,
                    damage = 1
                )
            ).subscribe {
                logger.info("[TESTING DATABASE] New ID Created: $it")
            }

            skillRepository.createNewCastedSkill(
                Skill(
                    name = "Created and Retrieved",
                    type = SkillType.SKILL_TYPE_NONE.value,
                    damage = 1
                )
            ).doOnNext {
                logger.warn("[TESTING DATABASE] New ID Generated: $it")
            }.flatMap { skillId ->
                skillRepository.getSkillById(skillId!!).map { it ->
                    SkillDto(it.skillId, SkillType.fromInt(it.type), it.name, it.damage, it.effective)
                }
            }.subscribe {
                logger.info("[TESTING DATABASE] Created and Retrieved: $it")
            }

            skillRepository.getAllSkills().subscribe {
                logger.info("[TESTING DATABASE] Retrieved: $it")
            }

            // testing services
            skillService.castSkill(
                SkillDto(
                    name = "Test Service",
                    type = SkillType.SKILL_TYPE_UNKNOWN,
                    damage = 2
                )
            ).map { skillDto ->
                Skill(skillDto.skillId, skillDto.type.value, skillDto.name, skillDto.damage, skillDto.effective)
            }.subscribe {
                logger.info("[TESTING SERVICE] Retrieved: $it")
            }
        }
}
