package com.kamilKurde.kalc.units.data

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.distance.Transfer
import com.kamilKurde.kalc.units.time.Time

data class Data(
	var inBytes: BigDecimal
): KalcType<Data>()
{
	var inYobibytes by UnitDelegate(Multipliers.yobi)
	var inYottabytes by UnitDelegate(Multipliers.yotta)
	var inZebibytes by UnitDelegate(Multipliers.zebi)
	var inZettabytes by UnitDelegate(Multipliers.zetta)
	var inExbibytes by UnitDelegate(Multipliers.exbi)
	var inExabytes by UnitDelegate(Multipliers.exa)
	var inPebibytes by UnitDelegate(Multipliers.pebi)
	var inPetabytes by UnitDelegate(Multipliers.peta)
	var inTebibytes by UnitDelegate(Multipliers.tebi)
	var inTerabytes by UnitDelegate(Multipliers.tera)
	var inGibibytes by UnitDelegate(Multipliers.gibi)
	var inGigabytes by UnitDelegate(Multipliers.giga)
	var inMebibytes by UnitDelegate(Multipliers.mebi)
	var inMegabytes by UnitDelegate(Multipliers.mega)
	var inKibibytes by UnitDelegate(Multipliers.kibi)
	var inKilobytes by UnitDelegate(Multipliers.kilo)
	var inBits by UnitDelegate(Multipliers.bit * Multipliers.bit)
	var inYobibits by UnitDelegate(Multipliers.yobi * Multipliers.bit)
	var inYottabits by UnitDelegate(Multipliers.yotta * Multipliers.bit)
	var inZebibits by UnitDelegate(Multipliers.zebi * Multipliers.bit)
	var inZettabits by UnitDelegate(Multipliers.zetta * Multipliers.bit)
	var inEksbibits by UnitDelegate(Multipliers.exbi * Multipliers.bit)
	var inEksabits by UnitDelegate(Multipliers.exa * Multipliers.bit)
	var inPebibits by UnitDelegate(Multipliers.pebi * Multipliers.bit)
	var inPetabits by UnitDelegate(Multipliers.peta * Multipliers.bit)
	var inTebibits by UnitDelegate(Multipliers.tebi * Multipliers.bit)
	var inTerabits by UnitDelegate(Multipliers.tera * Multipliers.bit)
	var inGibibits by UnitDelegate(Multipliers.gibi * Multipliers.bit)
	var inGigabits by UnitDelegate(Multipliers.giga * Multipliers.bit)
	var inMebibits by UnitDelegate(Multipliers.mebi * Multipliers.bit)
	var inMegabits by UnitDelegate(Multipliers.mega * Multipliers.bit)
	var inKibibits by UnitDelegate(Multipliers.kibi * Multipliers.bit)
	var inKilobits by UnitDelegate(Multipliers.kilo * Multipliers.bit)

	override fun setComponent1(value: BigDecimal)
	{
		inBits = value
	}

	operator fun div(time: Time) =
		Transfer(inBytes / time.inSeconds)

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