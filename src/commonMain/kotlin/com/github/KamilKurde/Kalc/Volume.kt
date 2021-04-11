package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class VolumeUnits
{
	Kilometers3,
	Meters3,
	Barrels,
	Liters,
	Centimeters3
}

data class VolumeRange(val start: Volume, val end: Volume)
{
	operator fun contains(volume: Volume) =
		volume >= start && volume <= end
}

// function to use when instantiating Lenght class
fun Volume(
	value: Number,
	unit: VolumeUnits = VolumeUnits.Meters3
): Volume
{
	val initValue = BigDecimal.parseString(value.toString())
	return Volume(
		when (unit)
		{
			VolumeUnits.Kilometers3  -> initValue * Multipliers.kilo3
			VolumeUnits.Meters3      -> initValue
			VolumeUnits.Barrels      -> initValue * Multipliers.barrel
			VolumeUnits.Liters       -> initValue * Multipliers.liter
			VolumeUnits.Centimeters3 -> initValue * Multipliers.centi3
		}
	)
}

data class Volume(
	var m3: BigDecimal,
)
{
	var km3: BigDecimal
		get() = m3 / Multipliers.kilo3
		set(value)
		{
			m3 = value * Multipliers.kilo3
		}

	var barrel: BigDecimal
		get() = m3 / Multipliers.barrel
		set(value)
		{
			m3 = value * Multipliers.barrel
		}

	var liter: BigDecimal
		get() = m3 / Multipliers.liter
		set(value)
		{
			m3 = value * Multipliers.liter
		}

	var dm3: BigDecimal
		get() = liter
		set(value)
		{
			liter = value
		}

	var cm3: BigDecimal
		get() = m3 / Multipliers.centi3
		set(value)
		{
			m3 = value * Multipliers.centi3
		}

	operator fun unaryMinus() =
		Volume(-m3)

	operator fun plus(volume: Volume) =
		Volume(m3 + volume.m3)

	operator fun minus(volume: Volume) =
		Volume(m3 - volume.m3)

	operator fun times(number: Number) =
		Volume(BigDecimal.parseNumber(number) * m3)

	operator fun div(number: Number) =
		Volume(m3 / BigDecimal.parseNumber(number))

	operator fun rem(volume: Volume) =
		m3 % volume.m3

	operator fun rem(number: Number) =
		Volume(m3 % BigDecimal.parseNumber(number))

	operator fun rangeTo(volume: Volume) =
		VolumeRange(this, volume)

	operator fun plusAssign(volume: Volume)
	{
		m3 += volume.m3
	}

	operator fun minusAssign(volume: Volume)
	{
		m3 -= volume.m3
	}

	operator fun timesAssign(number: Number)
	{
		m3 *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		m3 /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		m3 %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Volume)
			return false
		return m3 == other.m3
	}

	operator fun compareTo(volume: Volume) =
		cm3.compareTo(volume.cm3)
}

val Number.km3 get() = Volume(this, VolumeUnits.Kilometers3)
val Number.m3 get() = Volume(this)
val Number.barrel get() = Volume(this, VolumeUnits.Barrels)
val Number.liter get() = Volume(this, VolumeUnits.Liters)
val Number.dm3 get() = this.liter
val Number.cm3 get() = Volume(this, VolumeUnits.Centimeters3)