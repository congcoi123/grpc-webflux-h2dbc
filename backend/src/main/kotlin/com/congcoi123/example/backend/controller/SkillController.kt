package com.congcoi123.example.backend.controller

import com.congcoi123.example.backend.grpc.CastSkill
import com.congcoi123.example.backend.skill.Skill
import io.reactivex.Single
import org.springframework.web.bind.annotation.RestController

@RestController
class SkillController(
    val castSkill: CastSkill
) {

//    fun cast(): Single<Skill> {
//    }
}