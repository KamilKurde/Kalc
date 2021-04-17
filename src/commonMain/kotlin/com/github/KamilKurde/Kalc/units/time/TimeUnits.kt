package com.github.KamilKurde.Kalc.units.time

import com.github.KamilKurde.Kalc.Multipliers
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