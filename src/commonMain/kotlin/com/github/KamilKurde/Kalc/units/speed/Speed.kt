package com.github.KamilKurde.Kalc.units.speed

import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Kalc.UnitDelegate
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.time.Time
import com.github.KamilKurde.Kalc.units.distance.Distance
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Speed(
	var inMetersPerSecond: BigDecimal,
): KalcType<Speed>()
{
	var inKilometersPerHour by UnitDelegate(Multipliers.kmph)
	var inMilesPerHour by UnitDelegate(Multipliers.mph)
	var inKnots by UnitDelegate(Multipliers.knot)
	var inFeetPerSecond by UnitDelegate(Multipliers.fps)

	operator fun times(time: Time) =
		Distance(inMetersPerSecond * time.inSeconds)

	override fun setComponent1(value: BigDecimal)
	{
		inMetersPerSecond = value
	}

	override fun t(value: BigDecimal): Speed = Speed(value)

	override fun toString() = super.toString()

	constructor(
		value: Number,
		unit: SpeedUnits = SpeedUnits.MetersPerSecond
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: SpeedUnits = SpeedUnits.MetersPerSecond
	): this(value * unit.multiplier)
}