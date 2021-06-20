package com.kamilKurde.kalc.units.speed

import com.soywiz.kbignum.BigNum
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class SpeedUnits(override val multiplier: BigNum): KalcEnum
{
	MetersPerSecond(BigNum.ONE),
	KilometersPerHour(Multipliers.kmph),
	MilesPerHour(Multipliers.mph),
	Knots(Multipliers.knot),
	FeetPerSecond(Multipliers.fps)
}