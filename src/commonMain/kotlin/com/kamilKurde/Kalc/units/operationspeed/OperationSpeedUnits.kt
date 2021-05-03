package com.kamilKurde.kalc.units.operationspeed

import com.kamilKurde.kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class OperationSpeedUnits(val multiplier: BigDecimal)
{
	YOPH(Multipliers.yotta * Multipliers.hour),
	ZOPH(Multipliers.zetta * Multipliers.hour),
	EOPH(Multipliers.exa * Multipliers.hour),
	POPH(Multipliers.peta * Multipliers.hour),
	TOPH(Multipliers.tera * Multipliers.hour),
	GOPH(Multipliers.giga * Multipliers.hour),
	MOPH(Multipliers.mega * Multipliers.hour),
	KOPH(Multipliers.kilo * Multipliers.hour),
	OPH(BigDecimal.ONE * Multipliers.hour),
	YOPM(Multipliers.yotta * Multipliers.minute),
	ZOPM(Multipliers.zetta * Multipliers.minute),
	EOPM(Multipliers.exa * Multipliers.minute),
	POPM(Multipliers.peta * Multipliers.minute),
	TOPM(Multipliers.tera * Multipliers.minute),
	GOPM(Multipliers.giga * Multipliers.minute),
	MOPM(Multipliers.mega * Multipliers.minute),
	KOPM(Multipliers.kilo * Multipliers.minute),
	OPM(BigDecimal.ONE * Multipliers.minute),
	YOPS(Multipliers.yotta),
	ZOPS(Multipliers.zetta),
	EOPS(Multipliers.exa),
	POPS(Multipliers.peta),
	TOPS(Multipliers.tera),
	GOPS(Multipliers.giga),
	MOPS(Multipliers.mega),
	KOPS(Multipliers.kilo),
	OPS(BigDecimal.ONE),
}