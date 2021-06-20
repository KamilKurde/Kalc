package com.kamilKurde.kalc.units.area

import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.units.distance.Distance
import com.kamilKurde.kalc.units.volume.Volume
import com.soywiz.kbignum.BigNum

class Area internal constructor(
	override var value: BigNum,
): KalcType<Area, AreaUnits>(AreaUnits.Meters2, AreaUnits.values())
{
	var inKilometers2 by UnitDelegate(AreaUnits.Kilometers2)
	var inMeters2 by UnitDelegate(AreaUnits.Meters2)
	var inDecimeters2 by UnitDelegate(AreaUnits.Decimeters2)
	var inCentimeters2 by UnitDelegate(AreaUnits.Centimeters2)
	var inMillimeters2 by UnitDelegate(AreaUnits.Millimeters2)
	var inNanometers2 by UnitDelegate(AreaUnits.Nanometers2)
	var inPicometers2 by UnitDelegate(AreaUnits.Picometers2)

	operator fun times(distance: Distance) =
		Volume(inMeters2 * distance.inMeters)

	override fun getInstance(value: BigNum): Area = Area(value)

	constructor(
		value: Number,
		unit: AreaUnits = AreaUnits.Meters2
	): this(BigNum(value.toString()), unit)

	constructor(
		value: BigNum,
		unit: AreaUnits = AreaUnits.Meters2
	): this(value * unit.multiplier)
}