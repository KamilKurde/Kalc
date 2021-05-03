package com.kamilKurde.kalc.units.volume

import com.kamilKurde.kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class VolumeUnits(val multiplier: BigDecimal)
{
	Kilometers3(Multipliers.kilo3),
	Megalitres(Multipliers.megalitre),
	Meters3(BigDecimal.ONE),
	Barrels(Multipliers.barrel),
	Liters(Multipliers.liter),
	Centimeters3(Multipliers.centi3),
	Milliliters(Multipliers.milli * Multipliers.liter)
}