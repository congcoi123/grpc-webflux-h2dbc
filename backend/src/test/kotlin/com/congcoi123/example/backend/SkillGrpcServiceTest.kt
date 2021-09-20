/**
The MIT License

Copyright (c) 2021 kong <congcoi123@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.congcoi123.example.backend

import com.congcoi123.example.backend.proto.skill.CastSkillRequest
import com.congcoi123.example.backend.proto.skill.RxSkillAPIGrpc
import com.congcoi123.example.backend.proto.skill.Skill
import com.congcoi123.example.backend.proto.skill.SkillType
import io.grpc.netty.NettyChannelBuilder
import io.reactivex.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.lognet.springboot.grpc.autoconfigure.GRpcServerProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles("test")
class SkillGrpcServiceTest(
    @Autowired private val gRpcProperties: GRpcServerProperties
) {

    private lateinit var caster: RxSkillAPIGrpc.RxSkillAPIStub

    @BeforeEach
    fun setup() {
        val channel = NettyChannelBuilder.forAddress("localhost", gRpcProperties.port)
            .usePlaintext()
            .build()

        caster = RxSkillAPIGrpc.newRxStub(channel)
    }

    @Test
    fun castSkillShouldReturnResult() {
        val skillProto = Skill.newBuilder()
            .setType(SkillType.SKILL_TYPE_FIRE)
            .setName("Boiling Point")
            .setDamage(30)
            .build()

        val request = Single.just(CastSkillRequest.newBuilder().setSkill(skillProto).build())
        val result = caster.castSkill(request)
            .map { it ->
                it.castedSkill
            }
            .blockingGet() as Skill

        assertAll({
            assert(skillProto.name == result.name)
            assert(skillProto.type == result.type)
            assert(skillProto.damage == result.damage)
        })
    }
}
