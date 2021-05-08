package com.kamilKurde.kalc.units.speed

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.distance.Distance
import com.kamilKurde.kalc.units.time.Time

data class Speed(
	var inMetersPerSecond: BigDecimal,
): KalcType<Speed, SpeedUnits>()
{
	var inKilometersPerHour by UnitDelegate(Multipliers.kmph)
	var inMilesPerHour by UnitDelegate(Multipliers.mph)
	var inKnots by UnitDelegate(Multipliers.knot)
	var inFeetPerSecond by UnitDelegate(Multipliers.fps)

	operator fun times(time: Time) =
		Distance(inMetersPerSecond * time.inSeconds)

	override fun getInstance(value: BigDecimal): Speed = Speed(value)

	override fun setComponent1(value: BigDecimal)
	{
		inMetersPerSecond = value
	}

	override val defaultUnit get() = SpeedUnits.MetersPerSecond

	constructor(
		value: Number,
		unit: SpeedUnits = SpeedUnits.MetersPerSecond
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: SpeedUnits = SpeedUnits.MetersPerSecond
	): this(value * unit.multiplier)
}