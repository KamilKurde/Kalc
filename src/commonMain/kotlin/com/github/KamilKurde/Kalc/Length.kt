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

class Length(
	value: Number,
	unit: LengthUnits = LengthUnits.Meters
)
{
	private val initValue = BigDecimal.parseString(value.toString())
	var m: BigDecimal = when (unit)
	{
		LengthUnits.Kilometers  -> initValue * 1_000
		LengthUnits.Meters      -> initValue
		LengthUnits.Decimeters  -> initValue / 10
		LengthUnits.Centimeters -> initValue / 100
		LengthUnits.Millimeters -> initValue / 1_000
		LengthUnits.Nanometers  -> initValue / 1_000_000_000
		LengthUnits.Picometers  -> initValue / 1_000_000_000_000L
	}
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
}

val Number.km get() = Length(this, LengthUnits.Kilometers)
val Number.m get() = Length(this)
val Number.dm get() = Length(this, LengthUnits.Decimeters)
val Number.cm get() = Length(this, LengthUnits.Centimeters)
val Number.mm get() = Length(this, LengthUnits.Millimeters)
val Number.nm get() = Length(this, LengthUnits.Nanometers)
val Number.pm get() = Length(this, LengthUnits.Picometers)