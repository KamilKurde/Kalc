package com.github.KamilKurde.Kalc.units.distance

import com.github.KamilKurde.Kalc.Multipliers
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