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
	var inMetersPerSecond: BigDecimal,
)
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

	operator fun unaryMinus() =
		Speed(-inMetersPerSecond)

	operator fun plus(speed: Speed) =
		Speed(inMetersPerSecond + speed.inMetersPerSecond)

	operator fun minus(speed: Speed) =
		Speed(inMetersPerSecond - speed.inMetersPerSecond)

	operator fun times(number: Number) =
		Speed(BigDecimal.parseNumber(number) * inMetersPerSecond)

	operator fun times(time: Time) =
		Distance(inMetersPerSecond * time.inSeconds)

	operator fun div(speed: Speed) =
		inMetersPerSecond / speed.inMetersPerSecond

	operator fun div(number: Number) =
		Speed(inMetersPerSecond / BigDecimal.parseNumber(number))

	operator fun rem(speed: Speed) =
		inMetersPerSecond % speed.inMetersPerSecond

	operator fun rem(number: Number) =
		Speed(inMetersPerSecond % BigDecimal.parseNumber(number))

	operator fun rangeTo(speed: Speed) =
		SpeedRange(this, speed)

	operator fun plusAssign(distance: Distance)
	{
		inMetersPerSecond += distance.inMeters
	}

	operator fun minusAssign(distance: Distance)
	{
		inMetersPerSecond -= distance.inMeters
	}

	operator fun timesAssign(number: Number)
	{
		inMetersPerSecond *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		inMetersPerSecond /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		inMetersPerSecond %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Speed)
			return false
		return inMetersPerSecond == other.inMetersPerSecond
	}

	operator fun compareTo(speed: Speed) =
		inFeetPerSecond.compareTo(speed.inFeetPerSecond)
}

val Number.metersPerSecond get() = Speed(this)
val Number.kilometersPerHour get() = Speed(this, SpeedUnits.KilometersPerHour)
val Number.milesPerHour get() = Speed(this, SpeedUnits.MilesPerHour)
val Number.knots get() = Speed(this, SpeedUnits.Knots)
val Number.feetPerSecond get() = Speed(this, SpeedUnits.FeetPerSecond)