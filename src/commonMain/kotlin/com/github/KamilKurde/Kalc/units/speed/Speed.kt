package com.github.KamilKurde.Kalc.units.speed

import com.github.KamilKurde.Kalc.Kalc
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.time.Time
import com.github.KamilKurde.Kalc.units.distance.Distance
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Speed(
	var inMetersPerSecond: BigDecimal,
): Kalc()
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

	operator fun compareTo(speed: Speed) =
		inFeetPerSecond.compareTo(speed.inFeetPerSecond)

	override fun toString() = readableString(component1())
}