package com.kamilKurde.kalc.units.time

import com.soywiz.kbignum.BigNum
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class TimeUnits(override val multiplier: BigNum): KalcEnum
{
	Years(Multipliers.year),
	Weeks(Multipliers.week),
	Days(Multipliers.day),
	Hours(Multipliers.hour),
	Minutes(Multipliers.minute),
	Seconds(BigNum.ONE),
	Milliseconds(Multipliers.milli),
	Nanoseconds(Multipliers.nano),
	Picoseconds(Multipliers.pico)
}