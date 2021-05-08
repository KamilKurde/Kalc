package com.kamilKurde.kalc.units.speed

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class SpeedUnits(override val multiplier: BigDecimal): KalcEnum
{
	MetersPerSecond(BigDecimal.ONE),
	KilometersPerHour(Multipliers.kmph),
	MilesPerHour(Multipliers.mph),
	Knots(Multipliers.knot),
	FeetPerSecond(Multipliers.fps)
}