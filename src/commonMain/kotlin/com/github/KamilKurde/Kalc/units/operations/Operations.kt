package com.github.KamilKurde.Kalc.units.computations

import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Kalc.UnitDelegate
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.OperationSpeed.OperationSpeed
import com.github.KamilKurde.Kalc.units.time.Time
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Operations(
	var inOperations: BigDecimal,
): KalcType<Operations>()
{
	var inYottaOperations by UnitDelegate(Multipliers.yotta)
	var inZettaOperations by UnitDelegate(Multipliers.zetta)
	var inExaOperations by UnitDelegate(Multipliers.exa)
	var inPetaOperations by UnitDelegate(Multipliers.peta)
	var inTeraOperations by UnitDelegate(Multipliers.tera)
	var inGigaOperations by UnitDelegate(Multipliers.giga)
	var inMegaOperations by UnitDelegate(Multipliers.mega)
	var inKiloOperations by UnitDelegate(Multipliers.kilo)

	operator fun div(time: Time) =
		OperationSpeed(inOperations / time.inSeconds)

	operator fun div(operationSpeed: OperationSpeed) =
		Time(inOperations / operationSpeed.inOPS)

	override fun setComponent1(value: BigDecimal)
	{
		inOperations = value
	}

	override fun t(value: BigDecimal): Operations = Operations(value)

	override fun toString() = super.toString()

	constructor(
		value: Number,
		unit: OperationsUnits = OperationsUnits.Operations
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: OperationsUnits = OperationsUnits.Operations
	): this(value * unit.multiplier)
}