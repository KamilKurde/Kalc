package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class DistanceUnits
{
	Kilometers,
	Meters,
	Decimeters,
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
): Distance
{
	val initValue = BigDecimal.parseString(value.toString())
	return Distance(
		when (unit)
		{
			DistanceUnits.Kilometers  -> initValue * Multipliers.kilo
			DistanceUnits.Meters      -> initValue
			DistanceUnits.Decimeters  -> initValue * Multipliers.deci
			DistanceUnits.Centimeters -> initValue * Multipliers.centi
			DistanceUnits.Millimeters -> initValue * Multipliers.milli
			DistanceUnits.Nanometers  -> initValue * Multipliers.nano
			DistanceUnits.Picometers  -> initValue * Multipliers.pico
		}
	)
}

data class Distance(
	var m: BigDecimal,
)
{
	var km: BigDecimal
		get() = m / Multipliers.kilo
		set(value)
		{
			m = value * Multipliers.kilo
		}
	var dm: BigDecimal
		get() = m / Multipliers.deci
		set(value)
		{
			m = value * Multipliers.deci
		}
	var cm: BigDecimal
		get() = m / Multipliers.centi
		set(value)
		{
			m = value * Multipliers.centi
		}
	var mm: BigDecimal
		get() = m / Multipliers.milli
		set(value)
		{
			m = value * Multipliers.milli
		}
	var nm: BigDecimal
		get() = m / Multipliers.nano
		set(value)
		{
			m = value * Multipliers.nano
		}
	var pm: BigDecimal
		get() = m / Multipliers.pico
		set(value)
		{
			m = value * Multipliers.pico
		}

	operator fun unaryMinus() =
		Distance(-m)

	operator fun plus(distance: Distance) =
		Distance(m + distance.m)

	operator fun minus(distance: Distance) =
		Distance(m - distance.m)

	operator fun times(distance: Distance) =
		Area(m * distance.m)

	operator fun times(number: Number) =
		Distance(BigDecimal.parseNumber(number) * m)

	operator fun times(area: Area) =
		area * this

	operator fun div(distance: Distance) =
		m / distance.m

	operator fun div(number: Number) =
		Distance(m / BigDecimal.parseNumber(number))

	operator fun div(time: Time) =
		Speed(m / time.s)

	operator fun div(speed: Speed) =
		Time(m / speed.mps)

	operator fun rem(distance: Distance) =
		m % distance.m

	operator fun rem(number: Number) =
		Distance(m % BigDecimal.parseNumber(number))

	operator fun rangeTo(distance: Distance) =
		DistanceRange(this, distance)

	operator fun plusAssign(distance: Distance)
	{
		m += distance.m
	}

	operator fun minusAssign(distance: Distance)
	{
		m -= distance.m
	}

	operator fun timesAssign(number: Number)
	{
		m *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		m /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		m %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Distance)
			return false
		return m == other.m
	}

	operator fun compareTo(distance: Distance) =
		pm.compareTo(distance.pm)
}

val Number.km get() = Distance(this, DistanceUnits.Kilometers)
val Number.m get() = Distance(this)
val Number.dm get() = Distance(this, DistanceUnits.Decimeters)
val Number.cm get() = Distance(this, DistanceUnits.Centimeters)
val Number.mm get() = Distance(this, DistanceUnits.Millimeters)
val Number.nm get() = Distance(this, DistanceUnits.Nanometers)
val Number.pm get() = Distance(this, DistanceUnits.Picometers)