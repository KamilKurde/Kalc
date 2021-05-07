package com.kamilKurde.kalc.units.density

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.mass.Mass
import com.kamilKurde.kalc.units.volume.Volume

class Density(
	var inGramsPerCentimeter3: BigDecimal
): KalcType<Density>()
{
	var inKilogramsPerMeter3 by UnitDelegate(Multipliers.kilo)
	var inKilogramPerLitre by UnitDelegate(BigDecimal.ONE)
	var inTonesPerMeter3 by UnitDelegate(BigDecimal.ONE)

	override var value
		get() = inGramsPerCentimeter3
		set(value)
		{
			inGramsPerCentimeter3 = value
		}

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