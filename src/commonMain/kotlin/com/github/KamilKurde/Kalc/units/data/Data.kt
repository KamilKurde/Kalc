package com.github.KamilKurde.Kalc.units.data

import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Kalc.UnitDelegate
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.distance.Distance
import com.github.KamilKurde.Kalc.units.volume.Volume
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Data(
	var inBits: BigDecimal
): KalcType<Data>()
{
	var inJobibytes by UnitDelegate(Multipliers.jobi * Multipliers.byte)
	var inJottabytes by UnitDelegate(Multipliers.jotta * Multipliers.byte)
	var inZebibytes by UnitDelegate(Multipliers.zebi * Multipliers.byte)
	var inZettabytes by UnitDelegate(Multipliers.zetta * Multipliers.byte)
	var inEksbibytes by UnitDelegate(Multipliers.eksbi * Multipliers.byte)
	var inEksabytes by UnitDelegate(Multipliers.eksa * Multipliers.byte)
	var inPebibytes by UnitDelegate(Multipliers.pebi * Multipliers.byte)
	var inPetabytes by UnitDelegate(Multipliers.peta * Multipliers.byte)
	var inTebibytes by UnitDelegate(Multipliers.tebi * Multipliers.byte)
	var inTerabytes by UnitDelegate(Multipliers.tera * Multipliers.byte)
	var inGibibytes by UnitDelegate(Multipliers.gibi * Multipliers.byte)
	var inGigabytes by UnitDelegate(Multipliers.giga * Multipliers.byte)
	var inMebibytes by UnitDelegate(Multipliers.mebi * Multipliers.byte)
	var inMegabytes by UnitDelegate(Multipliers.mega * Multipliers.byte)
	var inKibibytes by UnitDelegate(Multipliers.kibi * Multipliers.byte)
	var inKilobytes by UnitDelegate(Multipliers.kilo * Multipliers.byte)
	var inBytes by UnitDelegate(Multipliers.byte)
	var inJobibits by UnitDelegate(Multipliers.jobi)
	var inJottabits by UnitDelegate(Multipliers.jotta)
	var inZebibits by UnitDelegate(Multipliers.zebi)
	var inZettabits by UnitDelegate(Multipliers.zetta)
	var inEksbibits by UnitDelegate(Multipliers.eksbi)
	var inEksabits by UnitDelegate(Multipliers.eksa)
	var inPebibits by UnitDelegate(Multipliers.pebi)
	var inPetabits by UnitDelegate(Multipliers.peta)
	var inTebibits by UnitDelegate(Multipliers.tebi)
	var inTerabits by UnitDelegate(Multipliers.tera)
	var inGibibits by UnitDelegate(Multipliers.gibi)
	var inGigabits by UnitDelegate(Multipliers.giga)
	var inMebibits by UnitDelegate(Multipliers.mebi)
	var inMegabits by UnitDelegate(Multipliers.mega)
	var inKibibits by UnitDelegate(Multipliers.kibi)
	var inKilobits by UnitDelegate(Multipliers.kilo)

	override fun setComponent1(value: BigDecimal)
	{
		inBits = value
	}

	override fun t(value: BigDecimal): Data = Data(value)

	override fun toString() = super.toString()

	constructor(
		value: Number,
		unit: DataUnits = DataUnits.Bit
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: DataUnits = DataUnits.Bit
	): this(value * unit.multiplier)
}