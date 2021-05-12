package com.kamilKurde.kalc.units.operations

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.operationspeed.OperationSpeed
import com.kamilKurde.kalc.units.time.Time

class Operations internal constructor(
	override var value: BigDecimal
): KalcType<Operations, OperationsUnits>()
{
	override val defaultUnit get() = OperationsUnits.Operations

	var inYottaOperations by UnitDelegate(Multipliers.yotta)
	var inZettaOperations by UnitDelegate(Multipliers.zetta)
	var inExaOperations by UnitDelegate(Multipliers.exa)
	var inPetaOperations by UnitDelegate(Multipliers.peta)
	var inTeraOperations by UnitDelegate(Multipliers.tera)
	var inGigaOperations by UnitDelegate(Multipliers.giga)
	var inMegaOperations by UnitDelegate(Multipliers.mega)
	var inKiloOperations by UnitDelegate(Multipliers.kilo)
	var inOperations by UnitDelegate(BigDecimal.ONE)

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