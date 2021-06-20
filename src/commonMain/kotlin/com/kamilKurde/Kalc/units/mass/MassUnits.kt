package com.kamilKurde.kalc.units.mass

import com.soywiz.kbignum.BigNum
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class MassUnits(override val multiplier: BigNum): KalcEnum
{
	Tons(Multipliers.mega),
	Slugs(Multipliers.slug),
	Kilograms(Multipliers.kilo),
	Pounds(Multipliers.pound),
	Ounces(Multipliers.ounce),
	Decagrams(Multipliers.deca),
	Grams(BigNum.ONE),
	Milligrams(Multipliers.milli),
}