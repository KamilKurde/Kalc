package com.github.KamilKurde.Kalc.units.speed

import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal

fun Speed(
	value: Number,
	unit: SpeedUnits = SpeedUnits.MetersPerSecond
) = Speed(BigDecimal.parseNumber(value), unit)

fun Speed(
	value: BigDecimal,
	unit: SpeedUnits = SpeedUnits.MetersPerSecond
): Speed
{
	return Speed(
		value * when (unit)
		{
			SpeedUnits.KilometersPerHour -> Multipliers.kmph
			SpeedUnits.MilesPerHour      -> Multipliers.mph
			SpeedUnits.Knots             -> Multipliers.knot
			SpeedUnits.FeetPerSecond     -> Multipliers.fps
			else                         -> BigDecimal.ONE
		}
	)
}