package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class SpeedUnits
{
	MetersPerSecond,
	KilometersPerHour,
	MilesPerHour,
	Knots,
	FeetPerSecond
}

data class SpeedRange(val start: Speed, val end: Speed)
{
	operator fun contains(speed: Speed) =
		speed >= start && speed <= end
}

// function to use when instantiating Lenght class
fun Speed(
	value: Number,
	unit: SpeedUnits = SpeedUnits.MetersPerSecond
) = Speed(BigDecimal.parseNumber(value), unit)

fun Speed(
	value: BigDecimal,
	unit: SpeedUnits = SpeedUnits.MetersPerSecond
): Speed
{
	return Speed(
		value * when (unit)
		{
			SpeedUnits.KilometersPerHour -> Multipliers.kmph
			SpeedUnits.MilesPerHour      -> Multipliers.mph
			SpeedUnits.Knots             -> Multipliers.knot
			SpeedUnits.FeetPerSecond     -> Multipliers.fps
			else                         -> BigDecimal.ONE
		}
	)
}

data class Speed(
	var metersPerSecond: BigDecimal,
)
{
	var kilometersPerHour: BigDecimal
		get() = metersPerSecond / Multipliers.kmph
		set(value)
		{
			metersPerSecond = value * Multipliers.kmph
		}
	var milesPerHour: BigDecimal
		get() = metersPerSecond / Multipliers.mph
		set(value)
		{
			metersPerSecond = value * Multipliers.mph
		}
	var knots: BigDecimal
		get() = metersPerSecond / Multipliers.knot
		set(value)
		{
			metersPerSecond = value * Multipliers.knot
		}
	var feetPerSecond: BigDecimal
		get() = BigDecimal.parseNumber(metersPerSecond.toString().toDouble() / Multipliers.fps.toString().toDouble())
		set(value)
		{
			metersPerSecond = value * Multipliers.fps
		}

	operator fun unaryMinus() =
		Speed(-metersPerSecond)

	operator fun plus(speed: Speed) =
		Speed(metersPerSecond + speed.metersPerSecond)

	operator fun minus(speed: Speed) =
		Speed(metersPerSecond - speed.metersPerSecond)

	operator fun times(number: Number) =
		Speed(BigDecimal.parseNumber(number) * metersPerSecond)

	operator fun times(time: Time) =
		Distance(metersPerSecond * time.seconds)

	operator fun div(speed: Speed) =
		metersPerSecond / speed.metersPerSecond

	operator fun div(number: Number) =
		Speed(metersPerSecond / BigDecimal.parseNumber(number))

	operator fun rem(speed: Speed) =
		metersPerSecond % speed.metersPerSecond

	operator fun rem(number: Number) =
		Speed(metersPerSecond % BigDecimal.parseNumber(number))

	operator fun rangeTo(speed: Speed) =
		SpeedRange(this, speed)

	operator fun plusAssign(distance: Distance)
	{
		metersPerSecond += distance.meters
	}

	operator fun minusAssign(distance: Distance)
	{
		metersPerSecond -= distance.meters
	}

	operator fun timesAssign(number: Number)
	{
		metersPerSecond *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		metersPerSecond /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		metersPerSecond %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Speed)
			return false
		return metersPerSecond == other.metersPerSecond
	}

	operator fun compareTo(speed: Speed) =
		feetPerSecond.compareTo(speed.feetPerSecond)
}

val Number.metersPerSecond get() = Speed(this)
val Number.kilometersPerHour get() = Speed(this, SpeedUnits.KilometersPerHour)
val Number.milesPerHour get() = Speed(this, SpeedUnits.MilesPerHour)
val Number.knots get() = Speed(this, SpeedUnits.Knots)
val Number.feetPerSecond get() = Speed(this, SpeedUnits.FeetPerSecond)