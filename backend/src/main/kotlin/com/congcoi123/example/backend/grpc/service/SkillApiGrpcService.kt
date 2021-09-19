package com.congcoi123.example.backend.grpc.service

import com.congcoi123.example.backend.proto.skill.RxSkillAPIGrpc
import com.congcoi123.example.backend.service.SkillService
import org.lognet.springboot.grpc.GRpcService
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@GRpcService
class SkillApiGrpcService(
    private val skillService: SkillService
) : RxSkillAPIGrpc.SkillAPIImplBase() {

    private val logger: Logger = LoggerFactory.getLogger(SkillApiGrpcService::class.java)
}
