package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class VolumeUnits
{
	Kilometers3,
	Megalitres,
	Meters3,
	Barrels,
	Liters,
	Milliliters
}

data class VolumeRange(val start: Volume, val end: Volume)
{
	operator fun contains(volume: Volume) =
		volume >= start && volume <= end
}

// function to use when instantiating Volume class
fun Volume(
	value: Number,
	unit: VolumeUnits = VolumeUnits.Meters3
) = Volume(BigDecimal.parseString(value.toString()), unit)

fun Volume(
	value: BigDecimal,
	unit: VolumeUnits = VolumeUnits.Meters3
): Volume
{
	return Volume(
		value * when (unit)
		{
			VolumeUnits.Kilometers3 -> Multipliers.kilo3
			VolumeUnits.Megalitres  -> Multipliers.megaliter
			VolumeUnits.Barrels     -> Multipliers.barrel
			VolumeUnits.Liters      -> Multipliers.liter
			VolumeUnits.Milliliters -> Multipliers.milli * Multipliers.liter
			else                    -> BigDecimal.ONE
		}
	)
}

data class Volume(
	var meters3: BigDecimal,
)
{
	var kilometers3: BigDecimal
		get() = meters3 / Multipliers.kilo3
		set(value)
		{
			meters3 = value * Multipliers.kilo3
		}

	var megalitres: BigDecimal
		get() = liters / Multipliers.mega
		set(value)
		{
			liters = value * Multipliers.mega
		}

	var barrels: BigDecimal
		get() = meters3 / Multipliers.barrel
		set(value)
		{
			meters3 = value * Multipliers.barrel
		}

	var liters: BigDecimal
		get() = meters3 / Multipliers.liter
		set(value)
		{
			meters3 = value * Multipliers.liter
		}

	var decimeters3: BigDecimal
		get() = liters
		set(value)
		{
			liters = value
		}

	var milliliters: BigDecimal
		get() = liters / Multipliers.milli
		set(value)
		{
			meters3 = value * Multipliers.milli
		}

	operator fun unaryMinus() =
		Volume(-meters3)

	operator fun plus(volume: Volume) =
		Volume(meters3 + volume.meters3)

	operator fun minus(volume: Volume) =
		Volume(meters3 - volume.meters3)

	operator fun times(number: Number) =
		Volume(BigDecimal.parseNumber(number) * meters3)

	operator fun div(number: Number) =
		Volume(meters3 / BigDecimal.parseNumber(number))

	operator fun rem(volume: Volume) =
		meters3 % volume.meters3

	operator fun rem(number: Number) =
		Volume(meters3 % BigDecimal.parseNumber(number))

	operator fun rangeTo(volume: Volume) =
		VolumeRange(this, volume)

	operator fun plusAssign(volume: Volume)
	{
		meters3 += volume.meters3
	}

	operator fun minusAssign(volume: Volume)
	{
		meters3 -= volume.meters3
	}

	operator fun timesAssign(number: Number)
	{
		meters3 *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		meters3 /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		meters3 %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Volume)
			return false
		return meters3 == other.meters3
	}

	operator fun compareTo(volume: Volume) =
		milliliters.compareTo(volume.milliliters)
}

val Number.megalitres get() = Volume(this, VolumeUnits.Megalitres)
val Number.kilometers3 get() = Volume(this, VolumeUnits.Kilometers3)
val Number.meters3 get() = Volume(this)
val Number.barrels get() = Volume(this, VolumeUnits.Barrels)
val Number.liters get() = Volume(this, VolumeUnits.Liters)
val Number.decimeters3 get() = this.liters
val Number.milliliters get() = Volume(this, VolumeUnits.Milliliters)
val Number.centimeters3 get() = this.milliliters