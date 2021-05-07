package com.kamilKurde.kalc.units.mass

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.density.Density
import com.kamilKurde.kalc.units.volume.Volume

data class Mass(
	var inGrams: BigDecimal,
): KalcType<Mass>()
{
	var inTones by UnitDelegate(Multipliers.mega)
	var inSlugs by UnitDelegate(Multipliers.slug)
	var inYards by UnitDelegate(Multipliers.yard)
	var inKilograms by UnitDelegate(Multipliers.kilo)
	var inPounds by UnitDelegate(Multipliers.pound)
	var inOunces by UnitDelegate(Multipliers.ounce)
	var inDecagrams by UnitDelegate(Multipliers.deca)
	var inMilligrams by UnitDelegate(Multipliers.milli)

	operator fun div(volume: Volume) = Density(inGrams / volume.inCentimeters3)

	operator fun div(density: Density) = Volume(inKilograms / density.inKilogramsPerMeter3)

	override fun setComponent1(value: BigDecimal)
	{
		inGrams = value
	}

	override fun getInstance(value: BigDecimal): Mass = Mass(value)

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