package com.github.KamilKurde.Kalc.units.area

import com.github.KamilKurde.Kalc.Kalc.KalcInterface
import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.distance.Distance
import com.github.KamilKurde.Kalc.units.volume.Volume
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Area(
	var inMeters2: BigDecimal
): KalcType<Area>(), KalcInterface
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

	operator fun times(distance: Distance) =
		Volume(inMeters2 * distance.inMeters)

	override fun setComponent1(value: BigDecimal)
	{
		inMeters2 = value
	}

	override fun t(value: BigDecimal): Area = Area(value)

	override fun toString() = super.toString()
}