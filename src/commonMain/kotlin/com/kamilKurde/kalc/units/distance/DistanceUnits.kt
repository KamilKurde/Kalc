package com.kamilKurde.kalc.units.distance

import com.kamilKurde.kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class DistanceUnits(val multiplier: BigDecimal)
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