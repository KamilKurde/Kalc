package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class SpeedUnits
{
	MetersPerSecond,
	KilometersPerHour,
	MilesPerHour,
	Knots,
	FeetsPerSecond
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
): Speed
{
	val initValue = BigDecimal.parseString(value.toString())
	return Speed(
		when (unit)
		{
			SpeedUnits.MetersPerSecond   -> initValue
			SpeedUnits.KilometersPerHour -> initValue * Multipliers.kmph
			SpeedUnits.MilesPerHour      -> initValue * Multipliers.mph
			SpeedUnits.Knots             -> initValue * Multipliers.knot
			SpeedUnits.FeetsPerSecond    -> initValue * Multipliers.fps
		}
	)
}

data class Speed(
	var mps: BigDecimal,
)
{
	var kmph: BigDecimal
		get() = mps / Multipliers.kmph
		set(value)
		{
			mps = value * Multipliers.kmph
		}
	var mph: BigDecimal
		get() = mps / Multipliers.mph
		set(value)
		{
			mps = value * Multipliers.mph
		}
	var knots: BigDecimal
		get() = mps / Multipliers.knot
		set(value)
		{
			mps = value * Multipliers.knot
		}
	var fps: BigDecimal
		get() = BigDecimal.parseNumber(mps.toString().toDouble() / Multipliers.fps.toString().toDouble())
		set(value)
		{
			mps = value * Multipliers.fps
		}

	operator fun unaryMinus() =
		Speed(-mps)

	operator fun plus(speed: Speed) =
		Speed(mps + speed.mps)

	operator fun minus(speed: Speed) =
		Speed(mps - speed.mps)

	operator fun times(number: Number) =
		Speed(BigDecimal.parseNumber(number) * mps)

	operator fun times(time: Time) =
		Distance(mps * time.s)

	operator fun div(speed: Speed) =
		mps / speed.mps

	operator fun div(number: Number) =
		Speed(mps / BigDecimal.parseNumber(number))

	operator fun rem(speed: Speed) =
		mps % speed.mps

	operator fun rem(number: Number) =
		Speed(mps % BigDecimal.parseNumber(number))

	operator fun rangeTo(speed: Speed) =
		SpeedRange(this, speed)

	operator fun plusAssign(distance: Distance)
	{
		mps += distance.m
	}

	operator fun minusAssign(distance: Distance)
	{
		mps -= distance.m
	}

	operator fun timesAssign(number: Number)
	{
		mps *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		mps /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		mps %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Speed)
			return false
		return mps == other.mps
	}

	operator fun compareTo(speed: Speed) =
		fps.compareTo(speed.fps)
}

val Number.mps get() = Speed(this)
val Number.kmph get() = Speed(this, SpeedUnits.KilometersPerHour)
val Number.mph get() = Speed(this, SpeedUnits.MilesPerHour)
val Number.knots get() = Speed(this, SpeedUnits.Knots)
val Number.fps get() = Speed(this, SpeedUnits.FeetsPerSecond)