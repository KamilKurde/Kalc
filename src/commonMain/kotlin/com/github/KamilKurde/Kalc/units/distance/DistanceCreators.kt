package com.github.KamilKurde.Kalc.units.distance

import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

fun Distance(
	value: Number,
	unit: DistanceUnits = DistanceUnits.Meters
) = Distance(BigDecimal.parseString(value.toString()), unit)

fun Distance(
	value: BigDecimal,
	unit: DistanceUnits = DistanceUnits.Meters
): Distance
{
	return Distance(
		value * when (unit)
		{
			DistanceUnits.Miles       -> Multipliers.mile
			DistanceUnits.Kilometers  -> Multipliers.kilo
			DistanceUnits.Yards       -> Multipliers.yard
			DistanceUnits.Feet        -> Multipliers.foot
			DistanceUnits.Decimeters  -> Multipliers.deci
			DistanceUnits.Inches      -> Multipliers.inch
			DistanceUnits.Centimeters -> Multipliers.centi
			DistanceUnits.Millimeters -> Multipliers.milli
			DistanceUnits.Nanometers  -> Multipliers.nano
			DistanceUnits.Picometers  -> Multipliers.pico
			else                      -> BigDecimal.ONE
		}
	)
}