package com.github.KamilKurde.Kalc.units.density

import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Kalc.UnitDelegate
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.mass.Mass
import com.github.KamilKurde.Kalc.units.volume.Volume
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Density(
	var inGramsPerCentimeter3: BigDecimal
): KalcType<Density>()
{
	var inKilogramsPerMeter3 by UnitDelegate(Multipliers.kilo)
	var inKilogramPerLitre by UnitDelegate(BigDecimal.ONE)
	var inTonesPerMeter3 by UnitDelegate(BigDecimal.ONE)

	operator fun times(volume: Volume) = Mass(inGramsPerCentimeter3 * volume.inCentimeters3)

	override fun setComponent1(value: BigDecimal)
	{
		inGramsPerCentimeter3 = value
	}

	override fun t(value: BigDecimal): Density = Density(value)

	override fun toString() = super.toString()

	constructor(
		value: Number,
		unit: DensityUnits = DensityUnits.GramPerCentimeter3
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: DensityUnits = DensityUnits.GramPerCentimeter3
	): this(value * unit.multiplier)
}