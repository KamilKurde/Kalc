package com.github.KamilKurde.Kalc.units.volume

import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

fun Volume(
	value: Number,
	unit: VolumeUnits = VolumeUnits.Meters3
) = Volume(BigDecimal.parseString(value.toString()), unit)

fun Volume(
	value: BigDecimal,
	unit: VolumeUnits = VolumeUnits.Meters3
): Volume
{
	return Volume(
		value * when (unit)
		{
			VolumeUnits.Kilometers3 -> Multipliers.kilo3
			VolumeUnits.Megalitres  -> Multipliers.megalitre
			VolumeUnits.Barrels     -> Multipliers.barrel
			VolumeUnits.Liters      -> Multipliers.liter
			VolumeUnits.Milliliters -> Multipliers.milli * Multipliers.liter
			else                    -> BigDecimal.ONE
		}
	)
}