package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class LengthUnits
{
	Kilometers,
	Meters,
	Decimeters,
	Centimeters,
	Millimeters,
	Nanometers,
	Picometers
}

data class LengthRange(val start: Length, val end: Length)
{
	operator fun contains(length: Length) =
		length >= start && length <= end
}

// function to use when instantiating Lenght class
fun length(
	value: Number,
	unit: LengthUnits = LengthUnits.Meters
): Length
{
	val initValue = BigDecimal.parseString(value.toString())
	return Length(
		when (unit)
		{
			LengthUnits.Kilometers  -> initValue * 1_000
			LengthUnits.Meters      -> initValue
			LengthUnits.Decimeters  -> initValue / 10
			LengthUnits.Centimeters -> initValue / 100
			LengthUnits.Millimeters -> initValue / 1_000
			LengthUnits.Nanometers  -> initValue / 1_000_000_000
			LengthUnits.Picometers  -> initValue / 1_000_000_000_000L
		}
	)
}

data class Length(
	var m: BigDecimal,
)
{
	var km: BigDecimal
		get() = m / 1000
		set(value)
		{
			m = value * 1000
		}
	var dm: BigDecimal
		get() = m * 10
		set(value)
		{
			m = value / 10
		}
	var cm: BigDecimal
		get() = m * 100
		set(value)
		{
			m = value / 100
		}
	var mm: BigDecimal
		get() = m * 1_000
		set(value)
		{
			m = value / 1_000
		}
	var nm: BigDecimal
		get() = m * 1_000_000_000
		set(value)
		{
			m = value / 1_000_000_000
		}
	var pm: BigDecimal
		get() = m * 1_000_000_000_000L
		set(value)
		{
			m = value / 1_000_000_000_000L
		}

	operator fun unaryMinus() =
		Length(-m)

	operator fun plus(length: Length) =
		Length(m + length.m)

	operator fun minus(length: Length) =
		Length(m - length.m)

	operator fun times(number: Number) =
		Length(BigDecimal.parseString(number.toString()) * m)

	operator fun times(length: Length) =
		Area(m * length.m)

	operator fun div(number: Number) =
		Length(m / BigDecimal.parseString(number.toString()))

	operator fun rem(length: Length) =
		Length(m % length.m)

	operator fun rangeTo(length: Length) =
		LengthRange(this, length)

	operator fun plusAssign(length: Length)
	{
		m += length.m
	}

	operator fun minusAssign(length: Length)
	{
		m -= length.m
	}

	operator fun timesAssign(length: Length)
	{
		m *= length.m
	}

	operator fun divAssign(length: Length)
	{
		m /= length.m
	}

	operator fun remAssign(length: Length)
	{
		m %= length.m
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Length)
			return false
		return m == other.m
	}

	operator fun compareTo(length: Length) =
		pm.compareTo(length.pm)
}

val Number.km get() = length(this, LengthUnits.Kilometers)
val Number.m get() = length(this)
val Number.dm get() = length(this, LengthUnits.Decimeters)
val Number.cm get() = length(this, LengthUnits.Centimeters)
val Number.mm get() = length(this, LengthUnits.Millimeters)
val Number.nm get() = length(this, LengthUnits.Nanometers)
val Number.pm get() = length(this, LengthUnits.Picometers)