package com.github.KamilKurde.Kalc.units

import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
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

class Area(
	var inMeters2: BigDecimal,
)
{
	var inKilometers2: BigDecimal
		get() = inMeters2 / Multipliers.kilo2
		set(value)
		{
			inMeters2 = value * Multipliers.kilo2
		}
	var inDecimeters2: BigDecimal
		get() = inMeters2 / Multipliers.deci2
		set(value)
		{
			inMeters2 = value * Multipliers.deci2
		}
	var inCentimeters2: BigDecimal
		get() = inMeters2 / Multipliers.centi2
		set(value)
		{
			inMeters2 = value * Multipliers.centi2
		}
	var inMillimeters2: BigDecimal
		get() = inMeters2 / Multipliers.milli2
		set(value)
		{
			inMeters2 = value * Multipliers.milli2
		}
	var inNanometers2: BigDecimal
		get() = inMeters2 / Multipliers.nano2
		set(value)
		{
			inMeters2 = value * Multipliers.nano2
		}
	var inPicometers2: BigDecimal
		get() = inMeters2 / Multipliers.pico2
		set(value)
		{
			inMeters2 = value * Multipliers.pico2
		}

	operator fun unaryMinus() =
		Area(-inMeters2)

	operator fun plus(area: Area) =
		Area(inMeters2 + area.inMeters2)

	operator fun minus(area: Area) =
		Area(inMeters2 - area.inMeters2)

	operator fun times(distance: Distance) =
		Volume(inMeters2 * distance.inMeters)

	operator fun times(number: Number) =
		Area(BigDecimal.parseNumber(number) * inMeters2)

	operator fun div(area: Area) =
		Distance(inMeters2 / area.inMeters2)

	operator fun div(number: Number) =
		Area(inMeters2 / BigDecimal.parseNumber(number))

	operator fun rem(area: Area) =
		inMeters2 % area.inMeters2

	operator fun rem(number: Number) =
		Area(inMeters2 % BigDecimal.parseNumber(number))

	operator fun rangeTo(area: Area) =
		AreaRange(this, area)

	operator fun plusAssign(area: Area)
	{
		inMeters2 += area.inMeters2
	}

	operator fun minusAssign(area: Area)
	{
		inMeters2 -= area.inMeters2
	}

	operator fun timesAssign(number: Number)
	{
		inMeters2 *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		inMeters2 /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		inMeters2 %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Area)
			return false
		return inMeters2 == other.inMeters2
	}

	operator fun compareTo(area: Area) =
		inPicometers2.compareTo(area.inPicometers2)
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