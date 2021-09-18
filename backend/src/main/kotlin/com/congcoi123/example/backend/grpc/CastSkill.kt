package com.congcoi123.example.backend.grpc

import com.congcoi123.example.backend.skill.Skill
import io.reactivex.Single
import org.springframework.stereotype.Component

@Component
class CastSkill {

    fun cast(skill: Skill): Single<Skill> =
        Single.just(
            Skill.newBuilder()
                .setName(skill.name)
                .setDamage(skill.damage)
                .build()
        )
}
