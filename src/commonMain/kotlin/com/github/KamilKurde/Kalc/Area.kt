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

// function to use when instantiating Lenght class
fun area(
	value: Number,
	unit: AreaUnits = AreaUnits.Meters2
): Area
{
	val initValue = BigDecimal.parseString(value.toString())
	return Area(
		when (unit)
		{
			AreaUnits.Kilometers2  -> initValue * 1_000_000
			AreaUnits.Meters2      -> initValue
			AreaUnits.Decimeters2  -> initValue / 100
			AreaUnits.Centimeters2 -> initValue / 10_000
			AreaUnits.Millimeters2 -> initValue / 1_000_000
			AreaUnits.Nanometers2  -> initValue / BigDecimal.parseString("1000000000000000000")
			AreaUnits.Picometers2  -> initValue / BigDecimal.parseString("1000000000000000000000000")
		}
	)
}

data class Area(
	var m2: BigDecimal,
)
{
	var km2: BigDecimal
		get() = m2 / 1_000_000
		set(value)
		{
			m2 = value * 1_000_000
		}
	var dm2: BigDecimal
		get() = m2 * 100
		set(value)
		{
			m2 = value / 100
		}
	var cm2: BigDecimal
		get() = m2 * 10_000
		set(value)
		{
			m2 = value / 10_000
		}
	var mm2: BigDecimal
		get() = m2 * 1_000_000
		set(value)
		{
			m2 = value / 1_000_000
		}
	var nm2: BigDecimal
		get() = m2 * BigDecimal.parseString("1000000000000000000")
		set(value)
		{
			m2 = value / BigDecimal.parseString("1000000000000000000")
		}
	var pm2: BigDecimal
		get() = m2 * BigDecimal.parseString("1000000000000000000000000")
		set(value)
		{
			m2 = value / BigDecimal.parseString("1000000000000000000000000")
		}

	operator fun unaryMinus() =
		Area(-m2)

	operator fun plus(area: Area) =
		Area(m2 + area.m2)

	operator fun minus(area: Area) =
		Area(m2 - area.m2)

	operator fun times(number: Number) =
		Area(BigDecimal.parseString(number.toString()) * m2)

	operator fun div(number: Number) =
		Area(m2 / BigDecimal.parseString(number.toString()))

	operator fun rem(area: Area) =
		Area(m2 % area.m2)

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

	operator fun timesAssign(area: Area)
	{
		m2 *= area.m2
	}

	operator fun divAssign(area: Area)
	{
		m2 /= area.m2
	}

	operator fun remAssign(area: Area)
	{
		m2 %= area.m2
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

val Number.km2 get() = area(this, AreaUnits.Kilometers2)
val Number.m2 get() = area(this)
val Number.dm2 get() = area(this, AreaUnits.Decimeters2)
val Number.cm2 get() = area(this, AreaUnits.Centimeters2)
val Number.mm2 get() = area(this, AreaUnits.Millimeters2)
val Number.nm2 get() = area(this, AreaUnits.Nanometers2)
val Number.pm2 get() = area(this, AreaUnits.Picometers2)