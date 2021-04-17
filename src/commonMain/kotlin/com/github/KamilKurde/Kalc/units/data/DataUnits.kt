package com.github.KamilKurde.Kalc.units.data

import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class DataUnits(val multiplier: BigDecimal)
{
	Jobibyte(Multipliers.jobi * Multipliers.byte),
	Jottabyte(Multipliers.jotta * Multipliers.byte),
	Zebibyte(Multipliers.zebi * Multipliers.byte),
	Zettabyte(Multipliers.zetta * Multipliers.byte),
	Eksbibyte(Multipliers.eksbi * Multipliers.byte),
	Eksabyte(Multipliers.eksa * Multipliers.byte),
	Pebibyte(Multipliers.pebi * Multipliers.byte),
	Petabyte(Multipliers.peta * Multipliers.byte),
	Tebibyte(Multipliers.tebi * Multipliers.byte),
	Terabyte(Multipliers.tera * Multipliers.byte),
	Gibibyte(Multipliers.gibi * Multipliers.byte),
	Gigabyte(Multipliers.giga * Multipliers.byte),
	Mebibyte(Multipliers.mebi * Multipliers.byte),
	Megabyte(Multipliers.mega * Multipliers.byte),
	Kibibyte(Multipliers.kibi * Multipliers.byte),
	Kilobyte(Multipliers.kilo * Multipliers.byte),
	Byte(Multipliers.byte),
	Jobibit(Multipliers.jobi),
	Jottabit(Multipliers.jotta),
	Zebibit(Multipliers.zebi),
	Zettabit(Multipliers.zetta),
	Eksbibit(Multipliers.eksbi),
	Eksabit(Multipliers.eksa),
	Pebibit(Multipliers.pebi),
	Petabit(Multipliers.peta),
	Tebibit(Multipliers.tebi),
	Terabit(Multipliers.tera),
	Gibibit(Multipliers.gibi),
	Gigabit(Multipliers.giga),
	Mebibit(Multipliers.mebi),
	Megabit(Multipliers.mega),
	Kibibit(Multipliers.kibi),
	Kilobit(Multipliers.kilo),
	Bit(BigDecimal.ONE),
}