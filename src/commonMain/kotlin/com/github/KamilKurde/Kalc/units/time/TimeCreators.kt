package com.github.KamilKurde.Kalc.units.time

import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal

fun Time(
	value: Number,
	unit: TimeUnits = TimeUnits.Seconds
) = Time(BigDecimal.parseNumber(value), unit)

fun Time(
	value: BigDecimal,
	unit: TimeUnits = TimeUnits.Seconds
): Time
{
	return Time(
		value * when (unit)
		{
			TimeUnits.Years        -> Multipliers.year
			TimeUnits.Weeks        -> Multipliers.week
			TimeUnits.Days         -> Multipliers.day
			TimeUnits.Hours        -> Multipliers.hour
			TimeUnits.Minutes      -> Multipliers.minute
			TimeUnits.Milliseconds -> Multipliers.milli
			TimeUnits.Nanoseconds  -> Multipliers.nano
			TimeUnits.Picoseconds  -> Multipliers.pico
			else                   -> BigDecimal.ONE
		}
	)
}