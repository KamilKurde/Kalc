package com.kamilKurde.kalc.units.volume

import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.units.density.Density
import com.soywiz.kbignum.BigNum

class Volume internal constructor(
	override var value: BigNum
): KalcType<Volume, VolumeUnits>(VolumeUnits.Meters3, VolumeUnits.values())
{
	var inKilometers3 by UnitDelegate(VolumeUnits.Kilometers3)
	var inMegalitres by UnitDelegate(VolumeUnits.Megalitres)
	var inBarrels by UnitDelegate(VolumeUnits.Barrels)
	var inMeters3 by UnitDelegate(VolumeUnits.Meters3)
	var inLiters by UnitDelegate(VolumeUnits.Liters)
	var inDecimeters3 by UnitDelegate(VolumeUnits.Liters)
	var inCentimeters3 by UnitDelegate(VolumeUnits.Centimeters3)
	var inMilliliters3 by UnitDelegate(VolumeUnits.Milliliters3)

	operator fun times(density: Density) = density.times(this)

	override fun getInstance(value: BigNum): Volume = Volume(value)

	constructor(
		value: Number,
		unit: VolumeUnits = VolumeUnits.Meters3
	): this(BigNum(value.toString()), unit)

	constructor(
		value: BigNum,
		unit: VolumeUnits = VolumeUnits.Meters3
	): this(value * unit.multiplier)
}