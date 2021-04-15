package com.github.KamilKurde.Kalc.units.volume

import com.github.KamilKurde.Kalc.Kalc
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Volume(
	var inMeters3: BigDecimal,
): Kalc()
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

	operator fun compareTo(volume: Volume) =
		inMilliliters.compareTo(volume.inMilliliters)

	override fun toString() = readableString(component1())
}