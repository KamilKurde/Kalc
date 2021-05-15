package com.kamilKurde.kalc.units.density

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.mass.Mass
import com.kamilKurde.kalc.units.volume.Volume

class Density internal constructor(
	override var value: BigDecimal
): KalcType<Density, DensityUnits>(DensityUnits.GramPerCentimeter3, DensityUnits.values())
{
	var inKilogramsPerMeter3 by UnitDelegate(DensityUnits.KilogramPerMeter3)
	var inKilogramPerLitre by UnitDelegate(DensityUnits.KilogramPerLitre)
	var inTonesPerMeter3 by UnitDelegate(DensityUnits.TonePerMeter3)
	var inGramsPerCentimeter3 by UnitDelegate(DensityUnits.GramPerCentimeter3)

	operator fun times(volume: Volume) = Mass(inGramsPerCentimeter3 * volume.inCentimeters3)

	override fun getInstance(value: BigDecimal): Density = Density(value)

	constructor(
		value: Number,
		unit: DensityUnits = DensityUnits.GramPerCentimeter3
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: DensityUnits = DensityUnits.GramPerCentimeter3
	): this(value * unit.multiplier)
}