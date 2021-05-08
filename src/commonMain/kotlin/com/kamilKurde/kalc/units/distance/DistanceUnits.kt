package com.kamilKurde.kalc.units.distance

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class DistanceUnits(override val multiplier: BigDecimal): KalcEnum
{
	Miles(Multipliers.mile),
	Kilometers(Multipliers.kilo),
	Meters(BigDecimal.ONE),
	Yards(Multipliers.yard),
	Feet(Multipliers.foot),
	Decimeters(Multipliers.deci),
	Inches(Multipliers.inch),
	Centimeters(Multipliers.centi),
	Millimeters(Multipliers.milli),
	Nanometers(Multipliers.nano),
	Picometers(Multipliers.pico)
}