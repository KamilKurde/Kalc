package com.kamilKurde.kalc.units.mass

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class MassUnits(override val multiplier: BigDecimal): KalcEnum
{
	Tons(Multipliers.mega),
	Slugs(Multipliers.slug),
	Kilograms(Multipliers.kilo),
	Pounds(Multipliers.pound),
	Ounces(Multipliers.ounce),
	Decagrams(Multipliers.deca),
	Grams(BigDecimal.ONE),
	Milligrams(Multipliers.milli),
}