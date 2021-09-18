package com.congcoi123.example.backend.grpc.service

import com.congcoi123.example.backend.proto.skill.*
import io.reactivex.Single
import org.lognet.springboot.grpc.GRpcService
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@GRpcService
class SkillApiGrpcService(

) : RxSkillAPIGrpc.SkillAPIImplBase() {

    private val logger: Logger = LoggerFactory.getLogger(SkillApiGrpcService::class.java)

    override fun castSkill(request: Single<CastSkillRequest>): Single<CastSkillRequestResponse> {

        logger.warn(request.toString())

        return request.map { it ->
            CastSkillRequestResponse.newBuilder().setResult(
                CastedSkill.newBuilder().setSkillId(it.skill.skillId).setEffective(true).build()
            ).build()
        }
    }
}