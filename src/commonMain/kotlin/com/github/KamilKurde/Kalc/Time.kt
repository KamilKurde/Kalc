package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class TimeUnits
{
	Years,
	Weeks,
	Days,
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
) = Time(BigDecimal.parseNumber(value), unit)

fun Time(
	value: BigDecimal,
	unit: TimeUnits = TimeUnits.Seconds
): Time
{
	return Time(
		value * when (unit)
		{
			TimeUnits.Years        -> Multipliers.year
			TimeUnits.Weeks        -> Multipliers.week
			TimeUnits.Days         -> Multipliers.day
			TimeUnits.Hours        -> Multipliers.hour
			TimeUnits.Minutes      -> Multipliers.minute
			TimeUnits.Milliseconds -> Multipliers.milli
			TimeUnits.Nanoseconds  -> Multipliers.nano
			TimeUnits.Picoseconds  -> Multipliers.pico
			else                   -> BigDecimal.ONE
		}
	)
}

data class Time(
	var seconds: BigDecimal,
)
{
	var hours: BigDecimal
		get() = seconds / Multipliers.hour
		set(value)
		{
			seconds = value * Multipliers.hour
		}
	var minutes: BigDecimal
		get() = seconds / Multipliers.minute
		set(value)
		{
			seconds = value * Multipliers.minute
		}
	var milliseconds: BigDecimal
		get() = seconds / Multipliers.milli
		set(value)
		{
			seconds = value * Multipliers.milli
		}
	var nanoseconds: BigDecimal
		get() = seconds / Multipliers.nano
		set(value)
		{
			seconds = value * Multipliers.nano
		}
	var picoseconds: BigDecimal
		get() = seconds / Multipliers.pico
		set(value)
		{
			seconds = value * Multipliers.pico
		}

	operator fun unaryMinus() =
		Time(-seconds)

	operator fun plus(time: Time) =
		Time(seconds + time.seconds)

	operator fun minus(time: Time) =
		Time(seconds - time.seconds)

	operator fun times(number: Number) =
		Time(BigDecimal.parseNumber(number) * seconds)

	operator fun times(speed: Speed) =
		speed * this

	operator fun div(time: Time) =
		seconds / time.seconds

	operator fun div(number: Number) =
		Time(seconds / BigDecimal.parseNumber(number))

	operator fun rem(time: Time) =
		seconds % time.seconds

	operator fun rem(number: Number) =
		Time(seconds % BigDecimal.parseNumber(number))

	operator fun rangeTo(time: Time) =
		TimeRange(this, time)

	operator fun plusAssign(time: Time)
	{
		seconds += time.seconds
	}

	operator fun minusAssign(time: Time)
	{
		seconds -= time.seconds
	}

	operator fun timesAssign(number: Number)
	{
		seconds *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		seconds /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		seconds %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Time)
			return false
		return seconds == other.seconds
	}

	operator fun compareTo(time: Time) =
		picoseconds.compareTo(time.picoseconds)
}

val Number.years get() = Time(this, TimeUnits.Years)
val Number.weeks get() = Time(this, TimeUnits.Weeks)
val Number.days get() = Time(this, TimeUnits.Days)
val Number.hours get() = Time(this, TimeUnits.Hours)
val Number.minutes get() = Time(this, TimeUnits.Minutes)
val Number.seconds get() = Time(this)
val Number.milliseconds get() = Time(this, TimeUnits.Milliseconds)
val Number.nanoseconds get() = Time(this, TimeUnits.Nanoseconds)
val Number.picoseconds get() = Time(this, TimeUnits.Picoseconds)