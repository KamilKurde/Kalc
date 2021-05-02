package com.github.KamilKurde.Kalc.units.computations

import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class OperationsUnits(val multiplier: BigDecimal)
{
	YottaOperations(Multipliers.yotta),
	ZettaOperations(Multipliers.zetta),
	ExaOperations(Multipliers.exa),
	PetaOperations(Multipliers.peta),
	TeraOperations(Multipliers.tera),
	GigaOperations(Multipliers.giga),
	MegaOperations(Multipliers.mega),
	KiloOperationse(Multipliers.kilo),
	Operations(BigDecimal.ONE),
}