package com.github.KamilKurde.Kalc.units

import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
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
) = com.github.KamilKurde.Kalc.units.Time(BigDecimal.parseNumber(value), unit)

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

class Time(
	var inSeconds: BigDecimal,
)
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

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Time)
			return false
		return inSeconds == other.inSeconds
	}

	operator fun compareTo(time: Time) =
		inPicoseconds.compareTo(time.inPicoseconds)
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