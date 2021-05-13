package com.kamilKurde.kalc.units.operations

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.operationspeed.OperationSpeed
import com.kamilKurde.kalc.units.time.Time

class Operations internal constructor(
	override var value: BigDecimal
): KalcType<Operations, OperationsUnits>()
{
	override val defaultUnit get() = OperationsUnits.Operations

	var inYottaOperations by UnitDelegate(OperationsUnits.YottaOperations)
	var inZettaOperations by UnitDelegate(OperationsUnits.ZettaOperations)
	var inExaOperations by UnitDelegate(OperationsUnits.ExaOperations)
	var inPetaOperations by UnitDelegate(OperationsUnits.PetaOperations)
	var inTeraOperations by UnitDelegate(OperationsUnits.TeraOperations)
	var inGigaOperations by UnitDelegate(OperationsUnits.GigaOperations)
	var inMegaOperations by UnitDelegate(OperationsUnits.MegaOperations)
	var inKiloOperations by UnitDelegate(OperationsUnits.KiloOperationse)
	var inOperations by UnitDelegate(OperationsUnits.Operations)

	operator fun div(time: Time) =
		OperationSpeed(inOperations / time.inSeconds)

	operator fun div(operationSpeed: OperationSpeed) =
		Time(inOperations / operationSpeed.inOPS)

	override fun getInstance(value: BigDecimal): Operations = Operations(value)

	constructor(
		value: Number,
		unit: OperationsUnits = OperationsUnits.Operations
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: OperationsUnits = OperationsUnits.Operations
	): this(value * unit.multiplier)

	override val enums get() = OperationsUnits.values()
}