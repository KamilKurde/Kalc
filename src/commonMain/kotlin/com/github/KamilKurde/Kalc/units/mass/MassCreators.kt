package com.github.KamilKurde.Kalc.units.mass

import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

fun Mass(
	value: Number,
	unit: MassUnits = MassUnits.Grams
) = Mass(BigDecimal.parseString(value.toString()), unit)

fun Mass(
	value: BigDecimal,
	unit: MassUnits = MassUnits.Grams
) = Mass(
	value * when (unit)
	{
		MassUnits.Tons       -> Multipliers.mega
		MassUnits.Slugs      -> Multipliers.slug
		MassUnits.Kilograms  -> Multipliers.kilo
		MassUnits.Pounds     -> Multipliers.pound
		MassUnits.Ounces     -> Multipliers.ounce
		MassUnits.Decagrams  -> Multipliers.deca
		MassUnits.Milligrams -> Multipliers.milli
		else                 -> BigDecimal.ONE
	}
)