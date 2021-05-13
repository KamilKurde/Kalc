package com.kamilKurde.kalc.units.data

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class DataUnits(override val multiplier: BigDecimal): KalcEnum
{
	Yobibytes(Multipliers.yobi),
	Yottabytes(Multipliers.yotta),
	Zebibytes(Multipliers.zebi),
	Zettabytes(Multipliers.zetta),
	Exbibytes(Multipliers.exbi),
	Exabytes(Multipliers.exa),
	Pebibytes(Multipliers.pebi),
	Petabytes(Multipliers.peta),
	Tebibytes(Multipliers.tebi),
	Terabytes(Multipliers.tera),
	Gibibytes(Multipliers.gibi),
	Gigabytes(Multipliers.giga),
	Mebibytes(Multipliers.mebi),
	Megabytes(Multipliers.mega),
	Kibibytes(Multipliers.kibi),
	Kilobytes(Multipliers.kilo),
	Bytes(BigDecimal.ONE),
	Yobibits(Multipliers.yobi * Multipliers.bit),
	Yottabits(Multipliers.yotta * Multipliers.bit),
	Zebibits(Multipliers.zebi * Multipliers.bit),
	Zettabits(Multipliers.zetta * Multipliers.bit),
	Exbibits(Multipliers.exbi * Multipliers.bit),
	Exabits(Multipliers.exa * Multipliers.bit),
	Pebibits(Multipliers.pebi * Multipliers.bit),
	Petabits(Multipliers.peta * Multipliers.bit),
	Tebibits(Multipliers.tebi * Multipliers.bit),
	Terabits(Multipliers.tera * Multipliers.bit),
	Gibibits(Multipliers.gibi * Multipliers.bit),
	Gigabits(Multipliers.giga * Multipliers.bit),
	Mebibits(Multipliers.mebi * Multipliers.bit),
	Megabits(Multipliers.mega * Multipliers.bit),
	Kibibits(Multipliers.kibi * Multipliers.bit),
	Kilobits(Multipliers.kilo * Multipliers.bit),
	Bits(Multipliers.bit * Multipliers.bit),
}