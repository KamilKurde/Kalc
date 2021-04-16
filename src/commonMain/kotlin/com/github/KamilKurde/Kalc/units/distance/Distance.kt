package com.github.KamilKurde.Kalc.units.distance

import com.github.KamilKurde.Kalc.Kalc.KalcInterface
import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.units.speed.Speed
import com.github.KamilKurde.Kalc.units.time.Time
import com.github.KamilKurde.Kalc.units.area.Area
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Distance(
	var inMeters: BigDecimal,
): KalcType<Distance>(), KalcInterface
{
	var inMiles: BigDecimal
		get() = inMeters / Multipliers.mile
		set(value)
		{
			inMeters = value * Multipliers.mile
		}
	var inKilometers: BigDecimal
		get() = inMeters / Multipliers.kilo
		set(value)
		{
			inMeters = value * Multipliers.kilo
		}
	var inYards: BigDecimal
		get() = inMeters / Multipliers.yard
		set(value)
		{
			inMeters = value * Multipliers.yard
		}
	var inFeet: BigDecimal
		get() = inMeters / Multipliers.foot
		set(value)
		{
			inMeters = value * Multipliers.foot
		}
	var inDecimeters: BigDecimal
		get() = inMeters / Multipliers.deci
		set(value)
		{
			inMeters = value * Multipliers.deci
		}
	var inInches: BigDecimal
		get() = inMeters / Multipliers.inch
		set(value)
		{
			inMeters = value * Multipliers.inch
		}
	var inCentimeters: BigDecimal
		get() = inMeters / Multipliers.centi
		set(value)
		{
			inMeters = value * Multipliers.centi
		}
	var inMillimeters: BigDecimal
		get() = inMeters / Multipliers.milli
		set(value)
		{
			inMeters = value * Multipliers.milli
		}
	var inNanometers: BigDecimal
		get() = inMeters / Multipliers.nano
		set(value)
		{
			inMeters = value * Multipliers.nano
		}
	var inPicometers: BigDecimal
		get() = inMeters / Multipliers.pico
		set(value)
		{
			inMeters = value * Multipliers.pico
		}

	operator fun times(distance: Distance) =
		Area(inMeters * distance.inMeters)

	operator fun times(area: Area) =
		area * this

	operator fun div(time: Time) =
		Speed(inMeters / time.inSeconds)

	operator fun div(speed: Speed) =
		Time(inMeters / speed.inMetersPerSecond)

	override fun setComponent1(value: BigDecimal)
	{
		inMeters = value
	}

	override fun t(value: BigDecimal): Distance = Distance(value)

	override fun toString() = super.toString()
}