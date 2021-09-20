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
package com.congcoi123.example.backend.converter

import com.google.common.base.Converter
import com.congcoi123.example.backend.dto.SkillDto as DtoSkill
import com.congcoi123.example.backend.proto.skill.Skill as ProtoSkill

object SkillConverter : Converter<ProtoSkill, DtoSkill>() {

    override fun doForward(a: ProtoSkill): DtoSkill =
        DtoSkill(
            skillId = a.skillId,
            type = SkillTypeConverter.convert(a.type)!!,
            name = a.name,
            damage = a.damage,
            effective = a.effective
        )

    override fun doBackward(b: DtoSkill): ProtoSkill =
        ProtoSkill.newBuilder()
            .setSkillId(b.skillId!!)
            .setType(SkillTypeConverter.reverse().convert(b.type))
            .setName(b.name)
            .setDamage(b.damage)
            .setEffective(b.effective!!)
            .build()
}
