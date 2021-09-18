package com.congcoi123.example.backend.grpc.service

import com.congcoi123.example.backend.proto.skill.CastSkillRequest
import com.congcoi123.example.backend.proto.skill.CastSkillResponse
import com.congcoi123.example.backend.proto.skill.CastedSkill
import com.congcoi123.example.backend.proto.skill.RxSkillAPIGrpc
import com.congcoi123.example.backend.service.SkillService
import io.reactivex.Single
import org.lognet.springboot.grpc.GRpcService
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@GRpcService
class SkillApiGrpcService(
    private val skillService: SkillService
) : RxSkillAPIGrpc.SkillAPIImplBase() {

    private val logger: Logger = LoggerFactory.getLogger(SkillApiGrpcService::class.java)

    override fun castSkill(request: Single<CastSkillRequest>): Single<CastSkillResponse> {
        return request.map { it ->
            CastSkillResponse.newBuilder().setResult(
                CastedSkill.newBuilder().setSkillId(it.skill.skillId).setEffective(true).build()
            ).build()
        }
    }
}