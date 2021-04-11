package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class AreaUnits
{
	Kilometers2,
	Meters2,
	Decimeters2,
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
): Area
{
	val initValue = BigDecimal.parseString(value.toString())
	return Area(
		when (unit)
		{
			AreaUnits.Kilometers2  -> initValue * Multipliers.kilo2
			AreaUnits.Meters2      -> initValue
			AreaUnits.Decimeters2  -> initValue * Multipliers.deci2
			AreaUnits.Centimeters2 -> initValue * Multipliers.centi2
			AreaUnits.Millimeters2 -> initValue * Multipliers.milli2
			AreaUnits.Nanometers2  -> initValue * Multipliers.nano2
			AreaUnits.Picometers2  -> initValue * Multipliers.pico2
		}
	)
}

data class Area(
	var m2: BigDecimal,
)
{
	var km2: BigDecimal
		get() = m2 / Multipliers.kilo2
		set(value)
		{
			m2 = value * Multipliers.kilo2
		}
	var dm2: BigDecimal
		get() = m2 / Multipliers.deci2
		set(value)
		{
			m2 = value * Multipliers.deci2
		}
	var cm2: BigDecimal
		get() = m2 / Multipliers.centi2
		set(value)
		{
			m2 = value * Multipliers.centi2
		}
	var mm2: BigDecimal
		get() = m2 / Multipliers.milli2
		set(value)
		{
			m2 = value * Multipliers.milli2
		}
	var nm2: BigDecimal
		get() = m2 / Multipliers.nano2
		set(value)
		{
			m2 = value * Multipliers.nano2
		}
	var pm2: BigDecimal
		get() = m2 / Multipliers.pico2
		set(value)
		{
			m2 = value * Multipliers.pico2
		}

	operator fun unaryMinus() =
		Area(-m2)

	operator fun plus(area: Area) =
		Area(m2 + area.m2)

	operator fun minus(area: Area) =
		Area(m2 - area.m2)

	operator fun times(length: Length) =
		Volume(m2 * length.m)

	operator fun times(number: Number) =
		Area(BigDecimal.parseNumber(number) * m2)

	operator fun div(area: Area) =
		Length(m2 / area.m2)

	operator fun div(number: Number) =
		Area(m2 / BigDecimal.parseNumber(number))

	operator fun rem(area: Area) =
		m2 % area.m2

	operator fun rem(number: Number) =
		Area(m2 % BigDecimal.parseNumber(number))

	operator fun rangeTo(area: Area) =
		AreaRange(this, area)

	operator fun plusAssign(area: Area)
	{
		m2 += area.m2
	}

	operator fun minusAssign(area: Area)
	{
		m2 -= area.m2
	}

	operator fun timesAssign(number: Number)
	{
		m2 *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		m2 /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		m2 %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Area)
			return false
		return m2 == other.m2
	}

	operator fun compareTo(area: Area) =
		pm2.compareTo(area.pm2)
}

val Number.km2 get() = Area(this, AreaUnits.Kilometers2)
val Number.m2 get() = Area(this)
val Number.dm2 get() = Area(this, AreaUnits.Decimeters2)
val Number.cm2 get() = Area(this, AreaUnits.Centimeters2)
val Number.mm2 get() = Area(this, AreaUnits.Millimeters2)
val Number.nm2 get() = Area(this, AreaUnits.Nanometers2)
val Number.pm2 get() = Area(this, AreaUnits.Picometers2)