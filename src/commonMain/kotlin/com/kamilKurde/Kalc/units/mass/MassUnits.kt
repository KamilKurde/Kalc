package com.kamilKurde.kalc.units.mass

import com.kamilKurde.kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class MassUnits(val multiplier: BigDecimal)
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