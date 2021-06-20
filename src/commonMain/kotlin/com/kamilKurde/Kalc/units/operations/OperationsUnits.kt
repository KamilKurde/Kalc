package com.kamilKurde.kalc.units.operations

import com.soywiz.kbignum.BigNum
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class OperationsUnits(override val multiplier: BigNum): KalcEnum
{
	YottaOperations(Multipliers.yotta),
	ZettaOperations(Multipliers.zetta),
	ExaOperations(Multipliers.exa),
	PetaOperations(Multipliers.peta),
	TeraOperations(Multipliers.tera),
	GigaOperations(Multipliers.giga),
	MegaOperations(Multipliers.mega),
	KiloOperationse(Multipliers.kilo),
	Operations(BigNum.ONE),
}