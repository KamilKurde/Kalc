package com.github.KamilKurde.Kalc.units.volume

import com.github.KamilKurde.Kalc.Kalc.KalcInterface
import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Volume(
	var inMeters3: BigDecimal,
): KalcType<Volume>(), KalcInterface
{
	var inKilometers3: BigDecimal
		get() = inMeters3 / Multipliers.kilo3
		set(value)
		{
			inMeters3 = value * Multipliers.kilo3
		}

	var inMegalitres: BigDecimal
		get() = inLiters / Multipliers.mega
		set(value)
		{
			inLiters = value * Multipliers.mega
		}

	var inBarrels: BigDecimal
		get() = inMeters3 / Multipliers.barrel
		set(value)
		{
			inMeters3 = value * Multipliers.barrel
		}

	var inLiters: BigDecimal
		get() = inMeters3 / Multipliers.liter
		set(value)
		{
			inMeters3 = value * Multipliers.liter
		}

	var inDecimeters3: BigDecimal
		get() = inLiters
		set(value)
		{
			inLiters = value
		}

	var inMilliliters: BigDecimal
		get() = inLiters / Multipliers.milli
		set(value)
		{
			inMeters3 = value * Multipliers.milli
		}

	override fun setComponent1(value: BigDecimal)
	{
		inMeters3 = value
	}

	override fun t(value: BigDecimal): Volume = Volume(value)

	override fun toString() = super.toString()
}