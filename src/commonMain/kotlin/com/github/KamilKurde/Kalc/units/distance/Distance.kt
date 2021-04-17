package com.github.KamilKurde.Kalc.units.distance

import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Kalc.UnitDelegate
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.speed.Speed
import com.github.KamilKurde.Kalc.units.time.Time
import com.github.KamilKurde.Kalc.units.area.Area
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Distance(
	var inMeters: BigDecimal,
): KalcType<Distance>()
{
	var inMiles by UnitDelegate(Multipliers.mile)
	var inKilometers by UnitDelegate(Multipliers.kilo)
	var inYards by UnitDelegate(Multipliers.yard)
	var inFeet by UnitDelegate(Multipliers.foot)
	var inDecimeters by UnitDelegate(Multipliers.deci)
	var inInches by UnitDelegate(Multipliers.inch)
	var inCentimeters by UnitDelegate(Multipliers.centi)
	var inMillimeters by UnitDelegate(Multipliers.milli)
	var inNanometers by UnitDelegate(Multipliers.nano)
	var inPicometers by UnitDelegate(Multipliers.pico)

	operator fun times(distance: Distance) =
		Area(inMeters * distance.inMeters)

	operator fun times(area: Area) =
		area * this

	operator fun div(time: Time) =
		Speed(inMeters / time.inSeconds)

	operator fun div(speed: Speed) =
		Time(inMeters / speed.inMetersPerSecond)

	override fun setComponent1(value: BigDecimal)
	{
		inMeters = value
	}

	override fun t(value: BigDecimal): Distance = Distance(value)

	override fun toString() = super.toString()


	constructor(
		value: Number,
		unit: DistanceUnits = DistanceUnits.Meters
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: DistanceUnits = DistanceUnits.Meters
	): this(value * unit.multiplier)
}