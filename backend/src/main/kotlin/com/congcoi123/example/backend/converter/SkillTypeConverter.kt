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

import com.congcoi123.example.backend.enum.SkillType as EnumSkillType
import com.congcoi123.example.backend.proto.skill.SkillType as ProtoSkillType
import com.google.common.base.Converter

object SkillTypeConverter : Converter<ProtoSkillType, EnumSkillType>() {
    override fun doForward(a: ProtoSkillType): EnumSkillType =
        when(a) {
            ProtoSkillType.SKILL_TYPE_NONE -> EnumSkillType.SKILL_TYPE_NONE
            ProtoSkillType.SKILL_TYPE_UNKNOWN -> EnumSkillType.SKILL_TYPE_UNKNOWN
            ProtoSkillType.SKILL_TYPE_SUMMON -> EnumSkillType.SKILL_TYPE_SUMMON
            ProtoSkillType.SKILL_TYPE_FIRE -> EnumSkillType.SKILL_TYPE_FIRE
            ProtoSkillType.SKILL_TYPE_WATER -> EnumSkillType.SKILL_TYPE_WATER
            ProtoSkillType.SKILL_TYPE_WIND -> EnumSkillType.SKILL_TYPE_WIND
            ProtoSkillType.SKILL_TYPE_THUNDER -> EnumSkillType.SKILL_TYPE_THUNDER
            ProtoSkillType.SKILL_TYPE_ROCK -> EnumSkillType.SKILL_TYPE_ROCK
            ProtoSkillType.SKILL_TYPE_WOOD -> EnumSkillType.SKILL_TYPE_WOOD
            else -> throw NotImplementedError()
        }

    override fun doBackward(b: EnumSkillType): ProtoSkillType =
        when(b) {
            EnumSkillType.SKILL_TYPE_NONE -> ProtoSkillType.SKILL_TYPE_NONE
            EnumSkillType.SKILL_TYPE_UNKNOWN -> ProtoSkillType.SKILL_TYPE_UNKNOWN
            EnumSkillType.SKILL_TYPE_SUMMON -> ProtoSkillType.SKILL_TYPE_SUMMON
            EnumSkillType.SKILL_TYPE_FIRE -> ProtoSkillType.SKILL_TYPE_FIRE
            EnumSkillType.SKILL_TYPE_WATER -> ProtoSkillType.SKILL_TYPE_WATER
            EnumSkillType.SKILL_TYPE_WIND -> ProtoSkillType.SKILL_TYPE_WIND
            EnumSkillType.SKILL_TYPE_THUNDER -> ProtoSkillType.SKILL_TYPE_THUNDER
            EnumSkillType.SKILL_TYPE_ROCK -> ProtoSkillType.SKILL_TYPE_ROCK
            EnumSkillType.SKILL_TYPE_WOOD -> ProtoSkillType.SKILL_TYPE_WOOD
        }
}
