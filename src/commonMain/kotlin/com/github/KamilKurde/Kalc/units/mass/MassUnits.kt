package com.github.KamilKurde.Kalc.units.mass

import com.github.KamilKurde.Kalc.Multipliers
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