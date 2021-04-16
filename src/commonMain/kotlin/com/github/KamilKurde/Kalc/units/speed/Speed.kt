package com.github.KamilKurde.Kalc.units.speed

import com.github.KamilKurde.Kalc.Kalc.KalcInterface
import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.time.Time
import com.github.KamilKurde.Kalc.units.distance.Distance
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Speed(
	var inMetersPerSecond: BigDecimal,
): KalcType<Speed>(), KalcInterface
{
	var inKilometersPerHour: BigDecimal
		get() = inMetersPerSecond / Multipliers.kmph
		set(value)
		{
			inMetersPerSecond = value * Multipliers.kmph
		}
	var inMilesPerHour: BigDecimal
		get() = inMetersPerSecond / Multipliers.mph
		set(value)
		{
			inMetersPerSecond = value * Multipliers.mph
		}
	var inKnots: BigDecimal
		get() = inMetersPerSecond / Multipliers.knot
		set(value)
		{
			inMetersPerSecond = value * Multipliers.knot
		}
	var inFeetPerSecond: BigDecimal
		get() = BigDecimal.parseNumber(inMetersPerSecond.toString().toDouble() / Multipliers.fps.toString().toDouble())
		set(value)
		{
			inMetersPerSecond = value * Multipliers.fps
		}

	operator fun times(time: Time) =
		Distance(inMetersPerSecond * time.inSeconds)

	override fun setComponent1(value: BigDecimal)
	{
		inMetersPerSecond = value
	}

	override fun t(value: BigDecimal): Speed = Speed(value)

	override fun toString() = super.toString()
}