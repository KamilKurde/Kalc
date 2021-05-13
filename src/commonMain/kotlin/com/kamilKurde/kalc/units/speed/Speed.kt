package com.kamilKurde.kalc.units.speed

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.distance.Distance
import com.kamilKurde.kalc.units.time.Time

class Speed internal constructor(
	override var value: BigDecimal
): KalcType<Speed, SpeedUnits>()
{
	override val defaultUnit get() = SpeedUnits.MetersPerSecond

	var inMetersPerSecond by UnitDelegate(SpeedUnits.MetersPerSecond)
	var inKilometersPerHour by UnitDelegate(SpeedUnits.KilometersPerHour)
	var inMilesPerHour by UnitDelegate(SpeedUnits.MilesPerHour)
	var inKnots by UnitDelegate(SpeedUnits.Knots)
	var inFeetPerSecond by UnitDelegate(SpeedUnits.FeetPerSecond)

	operator fun times(time: Time) =
		Distance(inMetersPerSecond * time.inSeconds)

	override fun getInstance(value: BigDecimal): Speed = Speed(value)

	constructor(
		value: Number,
		unit: SpeedUnits = SpeedUnits.MetersPerSecond
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: SpeedUnits = SpeedUnits.MetersPerSecond
	): this(value * unit.multiplier)

	override val enums get() = SpeedUnits.values()
}