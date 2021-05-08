package com.kamilKurde.kalc.units.volume

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class VolumeUnits(override val multiplier: BigDecimal): KalcEnum
{
	Kilometers3(Multipliers.kilo3),
	Megalitres(Multipliers.megalitre),
	Meters3(BigDecimal.ONE),
	Barrels(Multipliers.barrel),
	Liters(Multipliers.liter),
	Centimeters3(Multipliers.centi3),
	Milliliters(Multipliers.milli * Multipliers.liter)
}