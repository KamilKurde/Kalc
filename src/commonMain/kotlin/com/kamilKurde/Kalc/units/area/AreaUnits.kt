package com.kamilKurde.kalc.units.area

import com.soywiz.kbignum.BigNum
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class AreaUnits(override val multiplier: BigNum): KalcEnum
{
	Kilometers2(Multipliers.kilo2),
	Meters2(BigNum.ONE),
	Decimeters2(Multipliers.deci2),
	Centimeters2(Multipliers.centi2),
	Millimeters2(Multipliers.milli2),
	Nanometers2(Multipliers.nano2),
	Picometers2(Multipliers.pico2)
}