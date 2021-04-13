package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class DistanceUnits
{
	Miles,
	Kilometers,
	Meters,
	Yards,
	Feet,
	Decimeters,
	Inches,
	Centimeters,
	Millimeters,
	Nanometers,
	Picometers
}

data class DistanceRange(val start: Distance, val end: Distance)
{
	operator fun contains(distance: Distance) =
		distance >= start && distance <= end
}

// function to use when instantiating Lenght class
fun Distance(
	value: Number,
	unit: DistanceUnits = DistanceUnits.Meters
) = Distance(BigDecimal.parseString(value.toString()), unit)

fun Distance(
	value: BigDecimal,
	unit: DistanceUnits = DistanceUnits.Meters
): Distance
{
	return Distance(
		value * when (unit)
		{
			DistanceUnits.Miles       -> Multipliers.mile
			DistanceUnits.Kilometers  -> Multipliers.kilo
			DistanceUnits.Yards       -> Multipliers.yard
			DistanceUnits.Feet        -> Multipliers.foot
			DistanceUnits.Decimeters  -> Multipliers.deci
			DistanceUnits.Inches      -> Multipliers.inch
			DistanceUnits.Centimeters -> Multipliers.centi
			DistanceUnits.Millimeters -> Multipliers.milli
			DistanceUnits.Nanometers  -> Multipliers.nano
			DistanceUnits.Picometers  -> Multipliers.pico
			else                      -> BigDecimal.ONE
		}
	)
}

data class Distance(
	var inMeters: BigDecimal,
)
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

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Distance)
			return false
		return inMeters == other.inMeters
	}

	operator fun compareTo(distance: Distance) =
		inPicometers.compareTo(distance.inPicometers)
}

val Number.miles get() = Distance(this, DistanceUnits.Miles)
val Number.kilometers get() = Distance(this, DistanceUnits.Kilometers)
val Number.meters get() = Distance(this)
val Number.yards get() = Distance(this, DistanceUnits.Yards)
val Number.feet get() = Distance(this, DistanceUnits.Feet)
val Number.decimeters get() = Distance(this, DistanceUnits.Decimeters)
val Number.inches get() = Distance(this, DistanceUnits.Inches)
val Number.centimeters get() = Distance(this, DistanceUnits.Centimeters)
val Number.millimeters get() = Distance(this, DistanceUnits.Millimeters)
val Number.nanometers get() = Distance(this, DistanceUnits.Nanometers)
val Number.picometers get() = Distance(this, DistanceUnits.Picometers)