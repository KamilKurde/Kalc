package com.kamilKurde.kalc.units.distance

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.area.Area
import com.kamilKurde.kalc.units.speed.Speed
import com.kamilKurde.kalc.units.time.Time

class Distance internal constructor(
	override var value: BigDecimal
): KalcType<Distance, DistanceUnits>()
{
	override val defaultUnit get() = DistanceUnits.Meters

	var inMiles by UnitDelegate(DistanceUnits.Miles)
	var inKilometers by UnitDelegate(DistanceUnits.Kilometers)
	var inMeters by UnitDelegate(DistanceUnits.Meters)
	var inYards by UnitDelegate(DistanceUnits.Yards)
	var inFeet by UnitDelegate(DistanceUnits.Feet)
	var inDecimeters by UnitDelegate(DistanceUnits.Decimeters)
	var inInches by UnitDelegate(DistanceUnits.Inches)
	var inCentimeters by UnitDelegate(DistanceUnits.Centimeters)
	var inMillimeters by UnitDelegate(DistanceUnits.Millimeters)
	var inNanometers by UnitDelegate(DistanceUnits.Nanometers)
	var inPicometers by UnitDelegate(DistanceUnits.Picometers)

	operator fun times(area: Area) =
		area * this

	operator fun times(distance: Distance) =
		Area(inMeters * distance.inMeters)

	operator fun div(time: Time) =
		Speed(inMeters / time.inSeconds)

	operator fun div(speed: Speed) =
		Time(inMeters / speed.inMetersPerSecond)

	override fun getInstance(value: BigDecimal): Distance = Distance(value)

	constructor(
		value: Number,
		unit: DistanceUnits = DistanceUnits.Meters
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: DistanceUnits = DistanceUnits.Meters
	): this(value * unit.multiplier)

	override val enums get() = DistanceUnits.values()
}