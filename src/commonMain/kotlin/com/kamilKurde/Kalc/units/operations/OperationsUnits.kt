package com.kamilKurde.kalc.units.computations

import com.kamilKurde.kalc.Multipliers
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