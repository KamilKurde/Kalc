package com.kamilKurde.kalc.units.time

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.speed.Speed

class Time internal constructor(
	override var value: BigDecimal
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

	override fun getInstance(value: BigDecimal): Time = Time(value)

	constructor(
		value: Number,
		unit: TimeUnits = TimeUnits.Seconds
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: TimeUnits = TimeUnits.Seconds
	): this(value * unit.multiplier)
}