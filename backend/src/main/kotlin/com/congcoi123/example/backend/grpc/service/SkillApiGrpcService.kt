package com.congcoi123.example.backend.grpc.service

import com.congcoi123.example.backend.converter.SkillConverter
import com.congcoi123.example.backend.proto.skill.CastSkillRequest
import com.congcoi123.example.backend.proto.skill.CastSkillResponse
import com.congcoi123.example.backend.proto.skill.RxSkillAPIGrpc
import com.congcoi123.example.backend.service.SkillService
import io.reactivex.Single
import org.lognet.springboot.grpc.GRpcService
import org.springframework.beans.factory.annotation.Autowired
import reactor.adapter.rxjava.RxJava2Adapter

@GRpcService
class SkillApiGrpcService(
    @Autowired private val skillService: SkillService
) : RxSkillAPIGrpc.SkillAPIImplBase() {

    override fun castSkill(request: Single<CastSkillRequest>): Single<CastSkillResponse> =
        request
            .map {
                it.skill
            }
            .map(SkillConverter::convert)
            .flatMap { skillDto ->
                RxJava2Adapter.monoToSingle(
                    skillService.castSkill(skillDto)
                        .map(SkillConverter.reverse()::convert)
                        .map { skillProto ->
                            CastSkillResponse.newBuilder().setCastedSkill(skillProto).build()
                        }
                )
            }
}
