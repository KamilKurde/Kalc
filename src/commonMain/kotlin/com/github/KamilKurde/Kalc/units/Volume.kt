package com.github.KamilKurde.Kalc.units

import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
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
			VolumeUnits.Megalitres  -> Multipliers.megalitre
			VolumeUnits.Barrels     -> Multipliers.barrel
			VolumeUnits.Liters      -> Multipliers.liter
			VolumeUnits.Milliliters -> Multipliers.milli * Multipliers.liter
			else                    -> BigDecimal.ONE
		}
	)
}

class Volume(
	var inMeters3: BigDecimal,
)
{
	var inKilometers3: BigDecimal
		get() = inMeters3 / Multipliers.kilo3
		set(value)
		{
			inMeters3 = value * Multipliers.kilo3
		}

	var inMegalitres: BigDecimal
		get() = inLiters / Multipliers.mega
		set(value)
		{
			inLiters = value * Multipliers.mega
		}

	var inBarrels: BigDecimal
		get() = inMeters3 / Multipliers.barrel
		set(value)
		{
			inMeters3 = value * Multipliers.barrel
		}

	var inLiters: BigDecimal
		get() = inMeters3 / Multipliers.liter
		set(value)
		{
			inMeters3 = value * Multipliers.liter
		}

	var inDecimeters3: BigDecimal
		get() = inLiters
		set(value)
		{
			inLiters = value
		}

	var inMilliliters: BigDecimal
		get() = inLiters / Multipliers.milli
		set(value)
		{
			inMeters3 = value * Multipliers.milli
		}

	operator fun unaryMinus() =
		Volume(-inMeters3)

	operator fun plus(volume: Volume) =
		Volume(inMeters3 + volume.inMeters3)

	operator fun minus(volume: Volume) =
		Volume(inMeters3 - volume.inMeters3)

	operator fun times(number: Number) =
		Volume(BigDecimal.parseNumber(number) * inMeters3)

	operator fun div(number: Number) =
		Volume(inMeters3 / BigDecimal.parseNumber(number))

	operator fun rem(volume: Volume) =
		inMeters3 % volume.inMeters3

	operator fun rem(number: Number) =
		Volume(inMeters3 % BigDecimal.parseNumber(number))

	operator fun rangeTo(volume: Volume) =
		VolumeRange(this, volume)

	operator fun plusAssign(volume: Volume)
	{
		inMeters3 += volume.inMeters3
	}

	operator fun minusAssign(volume: Volume)
	{
		inMeters3 -= volume.inMeters3
	}

	operator fun timesAssign(number: Number)
	{
		inMeters3 *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		inMeters3 /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		inMeters3 %= BigDecimal.parseNumber(number)
	}

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Volume)
			return false
		return inMeters3 == other.inMeters3
	}

	operator fun compareTo(volume: Volume) =
		inMilliliters.compareTo(volume.inMilliliters)
}

val Number.megalitres get() = Volume(this, VolumeUnits.Megalitres)
val Number.kilometers3 get() = Volume(this, VolumeUnits.Kilometers3)
val Number.meters3 get() = Volume(this)
val Number.barrels get() = Volume(this, VolumeUnits.Barrels)
val Number.liters get() = Volume(this, VolumeUnits.Liters)
val Number.decimeters3 get() = this.liters
val Number.milliliters get() = Volume(this, VolumeUnits.Milliliters)
val Number.centimeters3 get() = this.milliliters