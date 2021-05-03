package com.kamilKurde.kalc.units.data

import com.kamilKurde.kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class DataUnits(val multiplier: BigDecimal)
{
	Jobibyte(Multipliers.yobi),
	Yottabyte(Multipliers.yotta),
	Zebibyte(Multipliers.zebi),
	Zettabyte(Multipliers.zetta),
	Eksbibyte(Multipliers.exbi),
	Eksabyte(Multipliers.exa),
	Pebibyte(Multipliers.pebi),
	Petabyte(Multipliers.peta),
	Tebibyte(Multipliers.tebi),
	Terabyte(Multipliers.tera),
	Gibibyte(Multipliers.gibi),
	Gigabyte(Multipliers.giga),
	Mebibyte(Multipliers.mebi),
	Megabyte(Multipliers.mega),
	Kibibyte(Multipliers.kibi),
	Kilobyte(Multipliers.kilo),
	Byte(BigDecimal.ONE),
	Jobibit(Multipliers.yobi * Multipliers.bit),
	Yottabit(Multipliers.yotta * Multipliers.bit),
	Zebibit(Multipliers.zebi * Multipliers.bit),
	Zettabit(Multipliers.zetta * Multipliers.bit),
	Eksbibit(Multipliers.exbi * Multipliers.bit),
	Eksabit(Multipliers.exa * Multipliers.bit),
	Pebibit(Multipliers.pebi * Multipliers.bit),
	Petabit(Multipliers.peta * Multipliers.bit),
	Tebibit(Multipliers.tebi * Multipliers.bit),
	Terabit(Multipliers.tera * Multipliers.bit),
	Gibibit(Multipliers.gibi * Multipliers.bit),
	Gigabit(Multipliers.giga * Multipliers.bit),
	Mebibit(Multipliers.mebi * Multipliers.bit),
	Megabit(Multipliers.mega * Multipliers.bit),
	Kibibit(Multipliers.kibi * Multipliers.bit),
	Kilobit(Multipliers.kilo * Multipliers.bit),
	Bit(Multipliers.bit * Multipliers.bit),
}