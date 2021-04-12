package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class AreaUnits
{
	Mile2,
	Kilometers2,
	Meters2,
	Yard2,
	Feet2,
	Decimeters2,
	Inch2,
	Centimeters2,
	Millimeters2,
	Nanometers2,
	Picometers2
}

data class AreaRange(val start: Area, val end: Area)
{
	operator fun contains(area: Area) =
		area >= start && area <= end
}

// function to use when instantiating Area class
fun Area(
	value: Number,
	unit: AreaUnits = AreaUnits.Meters2
) = Area(BigDecimal.parseString(value.toString()), unit)

fun Area(
	value: BigDecimal,
	unit: AreaUnits = AreaUnits.Meters2
): Area
{
	return Area(
		value * when (unit)
		{
			AreaUnits.Mile2        -> Multipliers.mile2
			AreaUnits.Kilometers2  -> Multipliers.kilo2
			AreaUnits.Yard2        -> Multipliers.yard2
			AreaUnits.Feet2        -> Multipliers.foot2
			AreaUnits.Decimeters2  -> Multipliers.deci2
			AreaUnits.Inch2        -> Multipliers.inch2
			AreaUnits.Centimeters2 -> Multipliers.centi2
			AreaUnits.Millimeters2 -> Multipliers.milli2
			AreaUnits.Nanometers2  -> Multipliers.nano2
			AreaUnits.Picometers2  -> Multipliers.pico2
			else                   -> BigDecimal.ONE
		}
	)
}

data class Area(
	var meters2: BigDecimal,
)
{
	var kilometers2: BigDecimal
		get() = meters2 / Multipliers.kilo2
		set(value)
		{
			meters2 = value * Multipliers.kilo2
		}
	var decimeters2: BigDecimal
		get() = meters2 / Multipliers.deci2
		set(value)
		{
			meters2 = value * Multipliers.deci2
		}
	var centimeters2: BigDecimal
		get() = meters2 / Multipliers.centi2
		set(value)
		{
			meters2 = value * Multipliers.centi2
		}
	var millimeters2: BigDecimal
		get() = meters2 / Multipliers.milli2
		set(value)
		{
			meters2 = value * Multipliers.milli2
		}
	var nanometers2: BigDecimal
		get() = meters2 / Multipliers.nano2
		set(value)
		{
			meters2 = value * Multipliers.nano2
		}
	var picometers2: BigDecimal
		get() = meters2 / Multipliers.pico2
		set(value)
		{
			meters2 = value * Multipliers.pico2
		}

	operator fun unaryMinus() =
		Area(-meters2)

	operator fun plus(area: Area) =
		Area(meters2 + area.meters2)

	operator fun minus(area: Area) =
		Area(meters2 - area.meters2)

	operator fun times(distance: Distance) =
		Volume(meters2 * distance.meters)

	operator fun times(number: Number) =
		Area(BigDecimal.parseNumber(number) * meters2)

	operator fun div(area: Area) =
		Distance(meters2 / area.meters2)

	operator fun div(number: Number) =
		Area(meters2 / BigDecimal.parseNumber(number))

	operator fun rem(area: Area) =
		meters2 % area.meters2

	operator fun rem(number: Number) =
		Area(meters2 % BigDecimal.parseNumber(number))

	operator fun rangeTo(area: Area) =
		AreaRange(this, area)

	operator fun plusAssign(area: Area)
	{
		meters2 += area.meters2
	}

	operator fun minusAssign(area: Area)
	{
		meters2 -= area.meters2
	}

	operator fun timesAssign(number: Number)
	{
		meters2 *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		meters2 /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		meters2 %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Area)
			return false
		return meters2 == other.meters2
	}

	operator fun compareTo(area: Area) =
		picometers2.compareTo(area.picometers2)
}

val Number.mile2 get() = Area(this, AreaUnits.Mile2)
val Number.kilometers2 get() = Area(this, AreaUnits.Kilometers2)
val Number.meters2 get() = Area(this)
val Number.yard2 get() = Area(this, AreaUnits.Yard2)
val Number.feet2 get() = Area(this, AreaUnits.Feet2)
val Number.decimeters2 get() = Area(this, AreaUnits.Decimeters2)
val Number.inches2 get() = Area(this, AreaUnits.Inch2)
val Number.centimeters2 get() = Area(this, AreaUnits.Centimeters2)
val Number.millimeters2 get() = Area(this, AreaUnits.Millimeters2)
val Number.nanometers2 get() = Area(this, AreaUnits.Nanometers2)
val Number.picometers2 get() = Area(this, AreaUnits.Picometers2)