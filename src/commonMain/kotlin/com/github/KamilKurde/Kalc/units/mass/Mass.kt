package com.github.KamilKurde.Kalc.units.mass

import com.github.KamilKurde.Kalc.Kalc.KalcInterface
import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Kalc.UnitDelegate
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Mass(
	var inGrams: BigDecimal,
): KalcType<Mass>(), KalcInterface
{
	var inTones by UnitDelegate(Multipliers.mega)
	var inSlugs by UnitDelegate(Multipliers.slug)
	var inYards by UnitDelegate(Multipliers.yard)
	var inKilograms by UnitDelegate(Multipliers.kilo)
	var inPounds by UnitDelegate(Multipliers.pound)
	var inOunces by UnitDelegate(Multipliers.ounce)
	var inDecagrams by UnitDelegate(Multipliers.deca)
	var inMilligrams by UnitDelegate(Multipliers.milli)

	override fun setComponent1(value: BigDecimal)
	{
		inGrams = value
	}

	override fun t(value: BigDecimal): Mass = Mass(value)

	override fun toString() = super.toString()


	constructor(
		value: Number,
		unit: MassUnits = MassUnits.Grams
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: MassUnits = MassUnits.Grams
	): this(value * unit.multiplier)
}