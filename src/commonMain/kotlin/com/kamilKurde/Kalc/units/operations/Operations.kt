package com.kamilKurde.kalc.units.operations

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.operationspeed.OperationSpeed
import com.kamilKurde.kalc.units.time.Time

data class Operations(
	var inOperations: BigDecimal,
): KalcType<Operations, OperationsUnits>()
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

	override fun getInstance(value: BigDecimal): Operations = Operations(value)


	override fun setComponent1(value: BigDecimal)
	{
		inOperations = value
	}

	override val defaultUnit get() = OperationsUnits.Operations

	constructor(
		value: Number,
		unit: OperationsUnits = OperationsUnits.Operations
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: OperationsUnits = OperationsUnits.Operations
	): this(value * unit.multiplier)
}