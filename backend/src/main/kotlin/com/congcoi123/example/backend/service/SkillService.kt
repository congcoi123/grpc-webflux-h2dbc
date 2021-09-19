package com.congcoi123.example.backend.service

import com.congcoi123.example.backend.dto.CastedSkillDto
import com.congcoi123.example.backend.dto.SkillDto
import com.congcoi123.example.backend.repository.SkillRepository
import io.reactivex.Flowable
import io.reactivex.Single
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class SkillService(
    private val skillRepository: SkillRepository
) {

    suspend fun castSkill(skill: Single<SkillDto>): Single<CastedSkillDto> =
        skill.map {
            transformToCasted(it)
        }

    suspend fun castComboSkill(skill: Single<SkillDto>): Flowable<CastedSkillDto> =
        skill
            .toFlowable()
            .flatMap { Flowable.just(transformToCasted(it)) }

    suspend fun castMultipleSkill(skill: Flowable<SkillDto>): Flowable<CastedSkillDto> =
        skill.map {
            transformToCasted(it)
        }

    // TODO: Retrieve data from database sources
    private fun transformToCasted(skillDto: SkillDto): CastedSkillDto =
        CastedSkillDto(SkillDto(Random.nextLong(), skillDto.type, skillDto.name, skillDto.damage), Random.nextBoolean())
}
