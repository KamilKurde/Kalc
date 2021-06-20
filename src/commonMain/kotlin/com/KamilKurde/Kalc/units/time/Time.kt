package com.kamilKurde.kalc.units.time

import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.units.speed.Speed
import com.soywiz.kbignum.BigNum

class Time internal constructor(
	override var value: BigNum
): KalcType<Time, TimeUnits>(TimeUnits.Seconds, TimeUnits.values())
{
	var inHours by UnitDelegate(TimeUnits.Hours)
	var inMinutes by UnitDelegate(TimeUnits.Minutes)
	var inSeconds by UnitDelegate(TimeUnits.Seconds)
	var inMilliseconds by UnitDelegate(TimeUnits.Milliseconds)
	var inNanoseconds by UnitDelegate(TimeUnits.Nanoseconds)
	var inPicoseconds by UnitDelegate(TimeUnits.Picoseconds)

	operator fun times(speed: Speed) =
		speed * this

	override fun getInstance(value: BigNum): Time = Time(value)

	constructor(
		value: Number,
		unit: TimeUnits = TimeUnits.Seconds
	): this(BigNum(value.toString()), unit)

	constructor(
		value: BigNum,
		unit: TimeUnits = TimeUnits.Seconds
	): this(value * unit.multiplier)
}