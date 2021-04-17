package com.github.KamilKurde.Kalc.units.speed

import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class SpeedUnits(val multiplier: BigDecimal)
{
	MetersPerSecond(BigDecimal.ONE),
	KilometersPerHour(Multipliers.kmph),
	MilesPerHour(Multipliers.mph),
	Knots(Multipliers.knot),
	FeetPerSecond(Multipliers.fps)
}