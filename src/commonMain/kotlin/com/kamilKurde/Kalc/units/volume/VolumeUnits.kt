package com.kamilKurde.kalc.units.volume

import com.soywiz.kbignum.BigNum
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class VolumeUnits(override val multiplier: BigNum): KalcEnum
{
	Kilometers3(Multipliers.kilo3),
	Megalitres(Multipliers.megalitre),
	Meters3(BigNum.ONE),
	Barrels(Multipliers.barrel),
	Liters(Multipliers.liter),
	Centimeters3(Multipliers.centi3),
	Milliliters3(Multipliers.milli * Multipliers.liter)
}