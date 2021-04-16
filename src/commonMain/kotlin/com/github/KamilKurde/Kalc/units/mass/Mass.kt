package com.github.KamilKurde.Kalc.units.mass

import com.github.KamilKurde.Kalc.Kalc.KalcInterface
import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Mass(
	var inGrams: BigDecimal,
): KalcType<Mass>(), KalcInterface
{
	var inTones: BigDecimal
		get() = inGrams / Multipliers.mega
		set(value)
		{
			inGrams = value * Multipliers.mega
		}
	var inSlugs: BigDecimal
		get() = inGrams / Multipliers.slug
		set(value)
		{
			inGrams = value * Multipliers.slug
		}
	var inYards: BigDecimal
		get() = inGrams / Multipliers.yard
		set(value)
		{
			inGrams = value * Multipliers.yard
		}
	var inKilograms: BigDecimal
		get() = inGrams / Multipliers.kilo
		set(value)
		{
			inGrams = value * Multipliers.kilo
		}
	var inPounds: BigDecimal
		get() = inGrams / Multipliers.pound
		set(value)
		{
			inGrams = value * Multipliers.pound
		}
	var inOunces: BigDecimal
		get() = inGrams / Multipliers.ounce
		set(value)
		{
			inGrams = value * Multipliers.ounce
		}
	var inDecagrams: BigDecimal
		get() = inGrams / Multipliers.deca
		set(value)
		{
			inGrams = value * Multipliers.deca
		}
	var inMilligrams: BigDecimal
		get() = inGrams / Multipliers.milli
		set(value)
		{
			inGrams = value * Multipliers.milli
		}

	override fun setComponent1(value: BigDecimal)
	{
		inGrams = value
	}

	override fun t(value: BigDecimal): Mass = Mass(value)

	override fun toString() = super.toString()
}