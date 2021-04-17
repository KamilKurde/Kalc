package com.github.KamilKurde.Kalc.units.volume

import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Kalc.UnitDelegate
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.density.Density
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Volume(
	var inMeters3: BigDecimal,
): KalcType<Volume>()
{
	var inKilometers3 by UnitDelegate(Multipliers.kilo3)
	var inMegalitres by UnitDelegate(Multipliers.mega)
	var inBarrels by UnitDelegate(Multipliers.barrel)
	var inLiters by UnitDelegate(Multipliers.liter)
	var inDecimeters3 by UnitDelegate(Multipliers.liter)
	var inCentimeters3 by UnitDelegate(Multipliers.centi3)
	var inMilliliters by UnitDelegate(Multipliers.milli)

	operator fun times(density: Density) = density.times(this)

	override fun setComponent1(value: BigDecimal)
	{
		inMeters3 = value
	}

	override fun t(value: BigDecimal): Volume = Volume(value)

	override fun toString() = super.toString()

	constructor(
		value: Number,
		unit: VolumeUnits = VolumeUnits.Meters3
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: VolumeUnits = VolumeUnits.Meters3
	): this(value * unit.multiplier)
}