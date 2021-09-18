package com.congcoi123.example.backend.grpc.service

import com.congcoi123.example.backend.grpc.CastSkill
import com.congcoi123.example.backend.skill.CastSkillRequest
import com.congcoi123.example.backend.skill.CastSkillRequestResponse
import com.congcoi123.example.backend.skill.RxSkillAPIGrpc
import com.congcoi123.example.backend.skill.Skill
import io.reactivex.Flowable
import io.reactivex.Single
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class SkillApiGrpcService(
    val castSkill: CastSkill
) : RxSkillAPIGrpc.SkillAPIImplBase() {


}