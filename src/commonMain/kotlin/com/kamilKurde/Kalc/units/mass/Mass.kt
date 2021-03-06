package com.kamilKurde.kalc.units.mass

import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.units.density.Density
import com.kamilKurde.kalc.units.volume.Volume
import com.soywiz.kbignum.BigNum

class Mass internal constructor(
	override var value: BigNum
): KalcType<Mass, MassUnits>(MassUnits.Grams, MassUnits.values())
{
	var inTones by UnitDelegate(MassUnits.Tons)
	var inSlugs by UnitDelegate(MassUnits.Slugs)
	var inKilograms by UnitDelegate(MassUnits.Kilograms)
	var inPounds by UnitDelegate(MassUnits.Pounds)
	var inOunces by UnitDelegate(MassUnits.Ounces)
	var inDecagrams by UnitDelegate(MassUnits.Decagrams)
	var inGrams by UnitDelegate(MassUnits.Grams)
	var inMilligrams by UnitDelegate(MassUnits.Milligrams)

	operator fun div(volume: Volume) = Density(inGrams / volume.inCentimeters3)

	operator fun div(density: Density) = Volume(inKilograms / density.inKilogramsPerMeter3)

	override fun getInstance(value: BigNum): Mass = Mass(value)

	constructor(
		value: Number,
		unit: MassUnits = MassUnits.Grams
	): this(BigNum(value.toString()), unit)

	constructor(
		value: BigNum,
		unit: MassUnits = MassUnits.Grams
	): this(value * unit.multiplier)
}