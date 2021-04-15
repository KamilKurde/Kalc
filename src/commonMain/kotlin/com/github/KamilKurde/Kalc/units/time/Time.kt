package com.github.KamilKurde.Kalc.units.time

import com.github.KamilKurde.Kalc.Kalc
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.speed.Speed
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Time(
	var inSeconds: BigDecimal,
): Kalc()
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

	operator fun unaryMinus() =
		Time(-inSeconds)

	operator fun plus(time: Time) =
		Time(inSeconds + time.inSeconds)

	operator fun minus(time: Time) =
		Time(inSeconds - time.inSeconds)

	operator fun times(number: Number) =
		Time(BigDecimal.parseNumber(number) * inSeconds)

	operator fun times(speed: Speed) =
		speed * this

	operator fun div(time: Time) =
		inSeconds / time.inSeconds

	operator fun div(number: Number) =
		Time(inSeconds / BigDecimal.parseNumber(number))

	operator fun rem(time: Time) =
		inSeconds % time.inSeconds

	operator fun rem(number: Number) =
		Time(inSeconds % BigDecimal.parseNumber(number))

	operator fun rangeTo(time: Time) =
		TimeRange(this, time)

	operator fun plusAssign(time: Time)
	{
		inSeconds += time.inSeconds
	}

	operator fun minusAssign(time: Time)
	{
		inSeconds -= time.inSeconds
	}

	operator fun timesAssign(number: Number)
	{
		inSeconds *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		inSeconds /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		inSeconds %= BigDecimal.parseNumber(number)
	}

	operator fun compareTo(time: Time) =
		inPicoseconds.compareTo(time.inPicoseconds)

	override fun toString() = readableString(component1())
}