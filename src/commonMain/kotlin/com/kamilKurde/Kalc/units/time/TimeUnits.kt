package com.kamilKurde.kalc.units.time

import com.kamilKurde.kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class TimeUnits(val multiplier: BigDecimal)
{
	Years(Multipliers.year),
	Weeks(Multipliers.week),
	Days(Multipliers.day),
	Hours(Multipliers.hour),
	Minutes(Multipliers.minute),
	Seconds(BigDecimal.ONE),
	Milliseconds(Multipliers.milli),
	Nanoseconds(Multipliers.nano),
	Picoseconds(Multipliers.pico)
}