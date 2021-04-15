package com.github.KamilKurde.Kalc.units.distance

import com.github.KamilKurde.Kalc.Kalc
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.speed.Speed
import com.github.KamilKurde.Kalc.units.time.Time
import com.github.KamilKurde.Kalc.units.area.Area
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Distance(
	var inMeters: BigDecimal,
): Kalc()
{
	var inMiles: BigDecimal
		get() = inMeters / Multipliers.mile
		set(value)
		{
			inMeters = value * Multipliers.mile
		}
	var inKilometers: BigDecimal
		get() = inMeters / Multipliers.kilo
		set(value)
		{
			inMeters = value * Multipliers.kilo
		}
	var inYards: BigDecimal
		get() = inMeters / Multipliers.yard
		set(value)
		{
			inMeters = value * Multipliers.yard
		}
	var inFeet: BigDecimal
		get() = inMeters / Multipliers.foot
		set(value)
		{
			inMeters = value * Multipliers.foot
		}
	var inDecimeters: BigDecimal
		get() = inMeters / Multipliers.deci
		set(value)
		{
			inMeters = value * Multipliers.deci
		}
	var inInches: BigDecimal
		get() = inMeters / Multipliers.inch
		set(value)
		{
			inMeters = value * Multipliers.inch
		}
	var inCentimeters: BigDecimal
		get() = inMeters / Multipliers.centi
		set(value)
		{
			inMeters = value * Multipliers.centi
		}
	var inMillimeters: BigDecimal
		get() = inMeters / Multipliers.milli
		set(value)
		{
			inMeters = value * Multipliers.milli
		}
	var inNanometers: BigDecimal
		get() = inMeters / Multipliers.nano
		set(value)
		{
			inMeters = value * Multipliers.nano
		}
	var inPicometers: BigDecimal
		get() = inMeters / Multipliers.pico
		set(value)
		{
			inMeters = value * Multipliers.pico
		}

	operator fun unaryMinus() =
		Distance(-inMeters)

	operator fun plus(distance: Distance) =
		Distance(inMeters + distance.inMeters)

	operator fun minus(distance: Distance) =
		Distance(inMeters - distance.inMeters)

	operator fun times(distance: Distance) =
		Area(inMeters * distance.inMeters)

	operator fun times(number: Number) =
		Distance(BigDecimal.parseNumber(number) * inMeters)

	operator fun times(area: Area) =
		area * this

	operator fun div(distance: Distance) =
		inMeters / distance.inMeters

	operator fun div(number: Number) =
		Distance(inMeters / BigDecimal.parseNumber(number))

	operator fun div(time: Time) =
		Speed(inMeters / time.inSeconds)

	operator fun div(speed: Speed) =
		Time(inMeters / speed.inMetersPerSecond)

	operator fun rem(distance: Distance) =
		inMeters % distance.inMeters

	operator fun rem(number: Number) =
		Distance(inMeters % BigDecimal.parseNumber(number))

	operator fun rangeTo(distance: Distance) =
		DistanceRange(this, distance)

	operator fun plusAssign(distance: Distance)
	{
		inMeters += distance.inMeters
	}

	operator fun minusAssign(distance: Distance)
	{
		inMeters -= distance.inMeters
	}

	operator fun timesAssign(number: Number)
	{
		inMeters *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		inMeters /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		inMeters %= BigDecimal.parseNumber(number)
	}

	operator fun compareTo(distance: Distance) =
		inPicometers.compareTo(distance.inPicometers)

	override fun toString() = readableString(component1())
}