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
package com.congcoi123.example.backend.enum

enum class SkillType(
    val value: Int
) {
    SKILL_TYPE_NONE(value = 0),
    SKILL_TYPE_UNKNOWN(value = 1),
    SKILL_TYPE_SUMMON(value = 2),
    SKILL_TYPE_FIRE(value = 3),
    SKILL_TYPE_WATER(value = 4),
    SKILL_TYPE_WIND(value = 5),
    SKILL_TYPE_THUNDER(value = 6),
    SKILL_TYPE_ROCK(value = 7),
    SKILL_TYPE_WOOD(value = 8);

    companion object {
        fun fromInt(value: Int) = SkillType.values().first { it.value == value }
    }
}
