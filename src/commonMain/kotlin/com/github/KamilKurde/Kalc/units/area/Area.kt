package com.github.KamilKurde.Kalc.units.area

import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Kalc.UnitDelegate
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.distance.Distance
import com.github.KamilKurde.Kalc.units.volume.Volume
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Area(
	var inMeters2: BigDecimal
): KalcType<Area>()
{
	var inKilometers2 by UnitDelegate(Multipliers.kilo2)
	var inDecimeters2 by UnitDelegate(Multipliers.deci2)
	var inCentimeters2 by UnitDelegate(Multipliers.centi2)
	var inMillimeters2 by UnitDelegate(Multipliers.milli2)
	var inNanometers2 by UnitDelegate(Multipliers.nano2)
	var inPicometers2 by UnitDelegate(Multipliers.pico2)

	operator fun times(distance: Distance) =
		Volume(inMeters2 * distance.inMeters)

	override fun setComponent1(value: BigDecimal)
	{
		inMeters2 = value
	}

	override fun t(value: BigDecimal): Area = Area(value)

	override fun toString() = super.toString()

	constructor(
		value: Number,
		unit: AreaUnits = AreaUnits.Meters2
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: AreaUnits = AreaUnits.Meters2
	): this(value * unit.multiplier)
}