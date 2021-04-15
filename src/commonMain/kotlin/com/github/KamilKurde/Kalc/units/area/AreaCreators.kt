package com.github.KamilKurde.Kalc.units.area

import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal

fun Area(
	value: Number,
	unit: AreaUnits = AreaUnits.Meters2
) = Area(BigDecimal.parseNumber(value), unit)

fun Area(
	value: BigDecimal,
	unit: AreaUnits = AreaUnits.Meters2
): Area
{
	return Area(
		value * when (unit)
		{
			AreaUnits.Mile2        -> Multipliers.mile2
			AreaUnits.Kilometers2  -> Multipliers.kilo2
			AreaUnits.Yard2        -> Multipliers.yard2
			AreaUnits.Feet2        -> Multipliers.foot2
			AreaUnits.Decimeters2  -> Multipliers.deci2
			AreaUnits.Inch2        -> Multipliers.inch2
			AreaUnits.Centimeters2 -> Multipliers.centi2
			AreaUnits.Millimeters2 -> Multipliers.milli2
			AreaUnits.Nanometers2  -> Multipliers.nano2
			AreaUnits.Picometers2  -> Multipliers.pico2
			else                   -> BigDecimal.ONE
		}
	)
}