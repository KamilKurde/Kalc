package com.kamilKurde.kalc.units.volume

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.density.Density

class Volume internal constructor(
	override var value: BigDecimal
): KalcType<Volume, VolumeUnits>()
{
	override val defaultUnit get() = VolumeUnits.Meters3

	var inKilometers3 by UnitDelegate(VolumeUnits.Kilometers3)
	var inMegalitres by UnitDelegate(VolumeUnits.Megalitres)
	var inBarrels by UnitDelegate(VolumeUnits.Barrels)
	var inMeters3 by UnitDelegate(VolumeUnits.Meters3)
	var inLiters by UnitDelegate(VolumeUnits.Liters)
	var inDecimeters3 by UnitDelegate(VolumeUnits.Liters)
	var inCentimeters3 by UnitDelegate(VolumeUnits.Centimeters3)
	var inMilliliters3 by UnitDelegate(VolumeUnits.Milliliters3)

	operator fun times(density: Density) = density.times(this)

	override fun getInstance(value: BigDecimal): Volume = Volume(value)

	constructor(
		value: Number,
		unit: VolumeUnits = VolumeUnits.Meters3
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: VolumeUnits = VolumeUnits.Meters3
	): this(value * unit.multiplier)

	override val enums get() = VolumeUnits.values()
}