package com.github.KamilKurde.Kalc.units.volume

import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class VolumeUnits(val multiplier: BigDecimal)
{
	Kilometers3(Multipliers.kilo3),
	Megalitres(Multipliers.megalitre),
	Meters3(BigDecimal.ONE),
	Barrels(Multipliers.barrel),
	Liters(Multipliers.liter),
	Milliliters(Multipliers.milli * Multipliers.liter)
}