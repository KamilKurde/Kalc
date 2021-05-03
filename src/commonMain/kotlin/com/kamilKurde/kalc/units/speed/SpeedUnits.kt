package com.kamilKurde.kalc.units.speed

import com.kamilKurde.kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class SpeedUnits(val multiplier: BigDecimal)
{
	MetersPerSecond(BigDecimal.ONE),
	KilometersPerHour(Multipliers.kmph),
	MilesPerHour(Multipliers.mph),
	Knots(Multipliers.knot),
	FeetPerSecond(Multipliers.fps)
}