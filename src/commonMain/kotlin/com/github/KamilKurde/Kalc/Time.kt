package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class TimeUnits
{
	Hours,
	Minutes,
	Seconds,
	Milliseconds,
	Nanoseconds,
	Picoseconds
}

data class TimeRange(val start: Time, val end: Time)
{
	operator fun contains(time: Time) =
		time >= start && time <= end
}

// function to use when instantiating Lenght class
fun Time(
	value: Number,
	unit: TimeUnits = TimeUnits.Seconds
): Time
{
	val initValue = BigDecimal.parseString(value.toString())
	return Time(
		when (unit)
		{
			TimeUnits.Hours        -> initValue * Multipliers.hour
			TimeUnits.Minutes      -> initValue * Multipliers.minute
			TimeUnits.Seconds      -> initValue
			TimeUnits.Milliseconds -> initValue * Multipliers.milli
			TimeUnits.Nanoseconds  -> initValue * Multipliers.nano
			TimeUnits.Picoseconds  -> initValue * Multipliers.pico
		}
	)
}

data class Time(
	var s: BigDecimal,
)
{
	var h: BigDecimal
		get() = s / Multipliers.hour
		set(value)
		{
			s = value * Multipliers.hour
		}
	var min: BigDecimal
		get() = s / Multipliers.minute
		set(value)
		{
			s = value * Multipliers.minute
		}
	var ms: BigDecimal
		get() = s / Multipliers.milli
		set(value)
		{
			s = value * Multipliers.milli
		}
	var ns: BigDecimal
		get() = s / Multipliers.nano
		set(value)
		{
			s = value * Multipliers.nano
		}
	var ps: BigDecimal
		get() = s / Multipliers.pico
		set(value)
		{
			s = value * Multipliers.pico
		}

	operator fun unaryMinus() =
		Time(-s)

	operator fun plus(time: Time) =
		Time(s + time.s)

	operator fun minus(time: Time) =
		Time(s - time.s)

	operator fun times(number: Number) =
		Time(BigDecimal.parseNumber(number) * s)

	operator fun times(speed: Speed) =
		speed * this

	operator fun div(time: Time) =
		s / time.s

	operator fun div(number: Number) =
		Time(s / BigDecimal.parseNumber(number))

	operator fun rem(time: Time) =
		s % time.s

	operator fun rem(number: Number) =
		Time(s % BigDecimal.parseNumber(number))

	operator fun rangeTo(time: Time) =
		TimeRange(this, time)

	operator fun plusAssign(time: Time)
	{
		s += time.s
	}

	operator fun minusAssign(time: Time)
	{
		s -= time.s
	}

	operator fun timesAssign(number: Number)
	{
		s *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		s /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		s %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Time)
			return false
		return s == other.s
	}

	operator fun compareTo(time: Time) =
		ps.compareTo(time.ps)
}

val Number.h get() = Time(this, TimeUnits.Hours)
val Number.min get() = Time(this, TimeUnits.Minutes)
val Number.s get() = Time(this)
val Number.ms get() = Time(this, TimeUnits.Milliseconds)
val Number.ns get() = Time(this, TimeUnits.Nanoseconds)
val Number.ps get() = Time(this, TimeUnits.Picoseconds)