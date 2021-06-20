package com.kamilKurde.kalc.units.speed

import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.units.distance.Distance
import com.kamilKurde.kalc.units.time.Time
import com.soywiz.kbignum.BigNum

class Speed internal constructor(
	override var value: BigNum
): KalcType<Speed, SpeedUnits>(SpeedUnits.MetersPerSecond, SpeedUnits.values())
{
	var inMetersPerSecond by UnitDelegate(SpeedUnits.MetersPerSecond)
	var inKilometersPerHour by UnitDelegate(SpeedUnits.KilometersPerHour)
	var inMilesPerHour by UnitDelegate(SpeedUnits.MilesPerHour)
	var inKnots by UnitDelegate(SpeedUnits.Knots)
	var inFeetPerSecond by UnitDelegate(SpeedUnits.FeetPerSecond)

	operator fun times(time: Time) =
		Distance(inMetersPerSecond * time.inSeconds)

	override fun getInstance(value: BigNum): Speed = Speed(value)

	constructor(
		value: Number,
		unit: SpeedUnits = SpeedUnits.MetersPerSecond
	): this(BigNum(value.toString()), unit)

	constructor(
		value: BigNum,
		unit: SpeedUnits = SpeedUnits.MetersPerSecond
	): this(value * unit.multiplier)
}