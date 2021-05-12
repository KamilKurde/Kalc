package com.kamilKurde.kalc.units.time

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.speed.Speed

class Time internal constructor(
	override var value: BigDecimal
): KalcType<Time, TimeUnits>()
{
	override val defaultUnit get() = TimeUnits.Seconds

	var inHours by UnitDelegate(Multipliers.hour)
	var inMinutes by UnitDelegate(Multipliers.minute)
	var inSeconds by UnitDelegate(BigDecimal.ONE)
	var inMilliseconds by UnitDelegate(Multipliers.milli)
	var inNanoseconds by UnitDelegate(Multipliers.nano)
	var inPicoseconds by UnitDelegate(Multipliers.pico)

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

	override val enums get() = TimeUnits.values()
}