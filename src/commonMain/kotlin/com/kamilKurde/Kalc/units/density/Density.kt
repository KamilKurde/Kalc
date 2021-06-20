package com.kamilKurde.kalc.units.density

import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.units.mass.Mass
import com.kamilKurde.kalc.units.volume.Volume
import com.soywiz.kbignum.BigNum

class Density internal constructor(
	override var value: BigNum
): KalcType<Density, DensityUnits>(DensityUnits.GramPerCentimeter3, DensityUnits.values())
{
	var inKilogramsPerMeter3 by UnitDelegate(DensityUnits.KilogramPerMeter3)
	var inKilogramPerLitre by UnitDelegate(DensityUnits.KilogramPerLitre)
	var inTonesPerMeter3 by UnitDelegate(DensityUnits.TonePerMeter3)
	var inGramsPerCentimeter3 by UnitDelegate(DensityUnits.GramPerCentimeter3)

	operator fun times(volume: Volume) = Mass(inGramsPerCentimeter3 * volume.inCentimeters3)

	override fun getInstance(value: BigNum): Density = Density(value)

	constructor(
		value: Number,
		unit: DensityUnits = DensityUnits.GramPerCentimeter3
	): this(BigNum(value.toString()), unit)

	constructor(
		value: BigNum,
		unit: DensityUnits = DensityUnits.GramPerCentimeter3
	): this(value * unit.multiplier)
}