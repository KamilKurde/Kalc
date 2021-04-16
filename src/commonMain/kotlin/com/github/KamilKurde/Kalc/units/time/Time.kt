package com.github.KamilKurde.Kalc.units.time

import com.github.KamilKurde.Kalc.Kalc.KalcInterface
import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.speed.Speed
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Time(
	var inSeconds: BigDecimal,
): KalcType<Time>(), KalcInterface
{
	var inHours: BigDecimal
		get() = inSeconds / Multipliers.hour
		set(value)
		{
			inSeconds = value * Multipliers.hour
		}
	var inMinutes: BigDecimal
		get() = inSeconds / Multipliers.minute
		set(value)
		{
			inSeconds = value * Multipliers.minute
		}
	var inMilliseconds: BigDecimal
		get() = inSeconds / Multipliers.milli
		set(value)
		{
			inSeconds = value * Multipliers.milli
		}
	var inNanoseconds: BigDecimal
		get() = inSeconds / Multipliers.nano
		set(value)
		{
			inSeconds = value * Multipliers.nano
		}
	var inPicoseconds: BigDecimal
		get() = inSeconds / Multipliers.pico
		set(value)
		{
			inSeconds = value * Multipliers.pico
		}

	operator fun times(speed: Speed) =
		speed * this

	override fun setComponent1(value: BigDecimal)
	{
		inSeconds = value
	}

	override fun t(value: BigDecimal): Time = Time(value)

	override fun toString() = super.toString()
}