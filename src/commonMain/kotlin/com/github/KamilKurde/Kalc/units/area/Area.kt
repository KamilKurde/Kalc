package com.github.KamilKurde.Kalc.units.area

import com.github.KamilKurde.Kalc.Kalc
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.distance.Distance
import com.github.KamilKurde.Kalc.units.volume.Volume
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Area(
	var inMeters2: BigDecimal
): Kalc()
{
	var inKilometers2: BigDecimal
		get() = inMeters2 / Multipliers.kilo2
		set(value)
		{
			inMeters2 = value * Multipliers.kilo2
		}
	var inDecimeters2: BigDecimal
		get() = inMeters2 / Multipliers.deci2
		set(value)
		{
			inMeters2 = value * Multipliers.deci2
		}
	var inCentimeters2: BigDecimal
		get() = inMeters2 / Multipliers.centi2
		set(value)
		{
			inMeters2 = value * Multipliers.centi2
		}
	var inMillimeters2: BigDecimal
		get() = inMeters2 / Multipliers.milli2
		set(value)
		{
			inMeters2 = value * Multipliers.milli2
		}
	var inNanometers2: BigDecimal
		get() = inMeters2 / Multipliers.nano2
		set(value)
		{
			inMeters2 = value * Multipliers.nano2
		}
	var inPicometers2: BigDecimal
		get() = inMeters2 / Multipliers.pico2
		set(value)
		{
			inMeters2 = value * Multipliers.pico2
		}

	operator fun unaryMinus() =
		Area(-inMeters2)

	operator fun plus(area: Area) =
		Area(inMeters2 + area.inMeters2)

	operator fun minus(area: Area) =
		Area(inMeters2 - area.inMeters2)

	operator fun times(distance: Distance) =
		Volume(inMeters2 * distance.inMeters)

	operator fun times(number: Number) =
		Area(BigDecimal.parseNumber(number) * inMeters2)

	operator fun div(area: Area) =
		Distance(inMeters2 / area.inMeters2)

	operator fun div(number: Number) =
		Area(inMeters2 / BigDecimal.parseNumber(number))

	operator fun rem(area: Area) =
		inMeters2 % area.inMeters2

	operator fun rem(number: Number) =
		Area(inMeters2 % BigDecimal.parseNumber(number))

	operator fun rangeTo(area: Area) =
		AreaRange(this, area)

	operator fun plusAssign(area: Area)
	{
		inMeters2 += area.inMeters2
	}

	operator fun minusAssign(area: Area)
	{
		inMeters2 -= area.inMeters2
	}

	operator fun timesAssign(number: Number)
	{
		inMeters2 *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		inMeters2 /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		inMeters2 %= BigDecimal.parseNumber(number)
	}

	operator fun compareTo(area: Area) =
		inPicometers2.compareTo(area.inPicometers2)

	override fun toString() = readableString(component1())
}