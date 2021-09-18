package com.congcoi123.example.backend.grpc.service

import com.congcoi123.example.backend.skill.*
import io.reactivex.Single
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class SkillApiGrpcService(

) : RxSkillAPIGrpc.SkillAPIImplBase() {

    override fun castSkill(request: Single<CastSkillRequest>): Single<CastSkillRequestResponse> =
        request.map {
            it -> CastSkillRequestResponse.newBuilder().setResult(
                CastedSkill.newBuilder().setSkillId(it.skill.skillId).setEffective(true).build()
            ).build()
        }
}