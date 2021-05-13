package com.kamilKurde.kalc.units.area

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.distance.Distance
import com.kamilKurde.kalc.units.volume.Volume

class Area internal constructor(
	override var value: BigDecimal,
): KalcType<Area, AreaUnits>()
{
	override val defaultUnit get() = AreaUnits.Meters2

	var inKilometers2 by UnitDelegate(AreaUnits.Kilometers2)
	var inMeters2 by UnitDelegate(AreaUnits.Meters2)
	var inDecimeters2 by UnitDelegate(AreaUnits.Decimeters2)
	var inCentimeters2 by UnitDelegate(AreaUnits.Centimeters2)
	var inMillimeters2 by UnitDelegate(AreaUnits.Millimeters2)
	var inNanometers2 by UnitDelegate(AreaUnits.Nanometers2)
	var inPicometers2 by UnitDelegate(AreaUnits.Picometers2)

	operator fun times(distance: Distance) =
		Volume(inMeters2 * distance.inMeters)

	override fun getInstance(value: BigDecimal): Area = Area(value)

	constructor(
		value: Number,
		unit: AreaUnits = AreaUnits.Meters2
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: AreaUnits = AreaUnits.Meters2
	): this(value * unit.multiplier)

	override val enums get() = AreaUnits.values()
}