package com.kamilKurde.kalc.units.distance

import com.soywiz.kbignum.BigNum
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class DistanceUnits(override val multiplier: BigNum): KalcEnum
{
	Miles(Multipliers.mile),
	Kilometers(Multipliers.kilo),
	Meters(BigNum.ONE),
	Yards(Multipliers.yard),
	Feet(Multipliers.foot),
	Decimeters(Multipliers.deci),
	Inches(Multipliers.inch),
	Centimeters(Multipliers.centi),
	Millimeters(Multipliers.milli),
	Nanometers(Multipliers.nano),
	Picometers(Multipliers.pico)
}