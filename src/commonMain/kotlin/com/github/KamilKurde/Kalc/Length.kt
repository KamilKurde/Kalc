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
fun Length(
	value: Number,
	unit: LengthUnits = LengthUnits.Meters
): Length
{
	val initValue = BigDecimal.parseString(value.toString())
	return Length(
		when (unit)
		{
			LengthUnits.Kilometers  -> initValue * Multipliers.kilo
			LengthUnits.Meters      -> initValue
			LengthUnits.Decimeters  -> initValue * Multipliers.deci
			LengthUnits.Centimeters -> initValue * Multipliers.centi
			LengthUnits.Millimeters -> initValue * Multipliers.milli
			LengthUnits.Nanometers  -> initValue * Multipliers.nano
			LengthUnits.Picometers  -> initValue * Multipliers.pico
		}
	)
}

data class Length(
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
		Length(-m)

	operator fun plus(length: Length) =
		Length(m + length.m)

	operator fun minus(length: Length) =
		Length(m - length.m)

	operator fun times(length: Length) =
		Area(m * length.m)

	operator fun times(number: Number) =
		Length(BigDecimal.parseNumber(number) * m)

	operator fun times(area: Area) =
		area * this

	operator fun div(length: Length) =
		m / length.m

	operator fun div(number: Number) =
		Length(m / BigDecimal.parseNumber(number))

	operator fun rem(length: Length) =
		m % length.m

	operator fun rem(number: Number) =
		Length(m % BigDecimal.parseNumber(number))

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
		if (other == null || other !is Length)
			return false
		return m == other.m
	}

	operator fun compareTo(length: Length) =
		pm.compareTo(length.pm)
}

val Number.km get() = Length(this, LengthUnits.Kilometers)
val Number.m get() = Length(this)
val Number.dm get() = Length(this, LengthUnits.Decimeters)
val Number.cm get() = Length(this, LengthUnits.Centimeters)
val Number.mm get() = Length(this, LengthUnits.Millimeters)
val Number.nm get() = Length(this, LengthUnits.Nanometers)
val Number.pm get() = Length(this, LengthUnits.Picometers)