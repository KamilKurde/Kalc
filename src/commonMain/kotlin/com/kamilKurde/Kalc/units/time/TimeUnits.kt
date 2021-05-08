package com.kamilKurde.kalc.units.time

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class TimeUnits(override val multiplier: BigDecimal): KalcEnum
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