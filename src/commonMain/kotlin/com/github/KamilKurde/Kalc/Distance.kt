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
	var meters: BigDecimal,
)
{
	var miles: BigDecimal
		get() = meters / Multipliers.mile
		set(value)
		{
			meters = value * Multipliers.mile
		}
	var kilometers: BigDecimal
		get() = meters / Multipliers.kilo
		set(value)
		{
			meters = value * Multipliers.kilo
		}
	var yards: BigDecimal
		get() = meters / Multipliers.yard
		set(value)
		{
			meters = value * Multipliers.yard
		}
	var feet: BigDecimal
		get() = meters / Multipliers.foot
		set(value)
		{
			meters = value * Multipliers.foot
		}
	var decimeters: BigDecimal
		get() = meters / Multipliers.deci
		set(value)
		{
			meters = value * Multipliers.deci
		}
	var inches: BigDecimal
		get() = meters / Multipliers.inch
		set(value)
		{
			meters = value * Multipliers.inch
		}
	var centimeters: BigDecimal
		get() = meters / Multipliers.centi
		set(value)
		{
			meters = value * Multipliers.centi
		}
	var millimeters: BigDecimal
		get() = meters / Multipliers.milli
		set(value)
		{
			meters = value * Multipliers.milli
		}
	var nanometers: BigDecimal
		get() = meters / Multipliers.nano
		set(value)
		{
			meters = value * Multipliers.nano
		}
	var picometers: BigDecimal
		get() = meters / Multipliers.pico
		set(value)
		{
			meters = value * Multipliers.pico
		}

	operator fun unaryMinus() =
		Distance(-meters)

	operator fun plus(distance: Distance) =
		Distance(meters + distance.meters)

	operator fun minus(distance: Distance) =
		Distance(meters - distance.meters)

	operator fun times(distance: Distance) =
		Area(meters * distance.meters)

	operator fun times(number: Number) =
		Distance(BigDecimal.parseNumber(number) * meters)

	operator fun times(area: Area) =
		area * this

	operator fun div(distance: Distance) =
		meters / distance.meters

	operator fun div(number: Number) =
		Distance(meters / BigDecimal.parseNumber(number))

	operator fun div(time: Time) =
		Speed(meters / time.seconds)

	operator fun div(speed: Speed) =
		Time(meters / speed.metersPerSecond)

	operator fun rem(distance: Distance) =
		meters % distance.meters

	operator fun rem(number: Number) =
		Distance(meters % BigDecimal.parseNumber(number))

	operator fun rangeTo(distance: Distance) =
		DistanceRange(this, distance)

	operator fun plusAssign(distance: Distance)
	{
		meters += distance.meters
	}

	operator fun minusAssign(distance: Distance)
	{
		meters -= distance.meters
	}

	operator fun timesAssign(number: Number)
	{
		meters *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		meters /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		meters %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Distance)
			return false
		return meters == other.meters
	}

	operator fun compareTo(distance: Distance) =
		picometers.compareTo(distance.picometers)
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