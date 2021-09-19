package com.congcoi123.example.backend.repository

import com.congcoi123.example.backend.dao.Skill
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface SkillRepository : ReactiveCrudRepository<Skill, Long>
