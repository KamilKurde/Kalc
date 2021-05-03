package com.kamilKurde.kalc.units.area

import com.kamilKurde.kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class AreaUnits(val multiplier: BigDecimal)
{
	Mile2(Multipliers.mile2),
	Kilometers2(Multipliers.kilo2),
	Meters2(BigDecimal.ONE),
	Yard2(Multipliers.yard2),
	Feet2(Multipliers.foot2),
	Decimeters2(Multipliers.deci2),
	Inch2(Multipliers.inch2),
	Centimeters2(Multipliers.centi2),
	Millimeters2(Multipliers.milli2),
	Nanometers2(Multipliers.nano2),
	Picometers2(Multipliers.pico2)
}