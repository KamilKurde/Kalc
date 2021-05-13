package com.kamilKurde.kalc.units.operationspeed

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.operations.Operations
import com.kamilKurde.kalc.units.time.Time

class OperationSpeed internal constructor(
	override var value: BigDecimal
): KalcType<OperationSpeed, OperationSpeedUnits>()
{
	override val defaultUnit get() = OperationSpeedUnits.OPS

	var inYOPH by UnitDelegate(OperationSpeedUnits.YOPH)
	var inZOPH by UnitDelegate(OperationSpeedUnits.ZOPH)
	var inEOPH by UnitDelegate(OperationSpeedUnits.EOPH)
	var inPOPH by UnitDelegate(OperationSpeedUnits.POPH)
	var inTOPH by UnitDelegate(OperationSpeedUnits.TOPH)
	var inGOPH by UnitDelegate(OperationSpeedUnits.GOPH)
	var inMOPH by UnitDelegate(OperationSpeedUnits.MOPH)
	var inKOPH by UnitDelegate(OperationSpeedUnits.KOPH)
	var inYOPM by UnitDelegate(OperationSpeedUnits.TOPM)
	var inZOPM by UnitDelegate(OperationSpeedUnits.ZOPM)
	var inEOPM by UnitDelegate(OperationSpeedUnits.EOPM)
	var inPOPM by UnitDelegate(OperationSpeedUnits.POPM)
	var inTOPM by UnitDelegate(OperationSpeedUnits.TOPM)
	var inGOPM by UnitDelegate(OperationSpeedUnits.GOPM)
	var inMOPM by UnitDelegate(OperationSpeedUnits.MOPM)
	var inKOPM by UnitDelegate(OperationSpeedUnits.KOPM)
	var inYOPS by UnitDelegate(OperationSpeedUnits.YOPS)
	var inZOPS by UnitDelegate(OperationSpeedUnits.ZOPS)
	var inEOPS by UnitDelegate(OperationSpeedUnits.EOPS)
	var inPOPS by UnitDelegate(OperationSpeedUnits.POPS)
	var inTOPS by UnitDelegate(OperationSpeedUnits.TOPS)
	var inGOPS by UnitDelegate(OperationSpeedUnits.GOPS)
	var inMOPS by UnitDelegate(OperationSpeedUnits.MOPS)
	var inKOPS by UnitDelegate(OperationSpeedUnits.KOPS)
	var inOPS by UnitDelegate(OperationSpeedUnits.OPS)

	operator fun times(time: Time) =
		Operations(inOPS * time.inSeconds)

	override fun getInstance(value: BigDecimal): OperationSpeed = OperationSpeed(value)

	constructor(
		value: Number,
		unit: OperationSpeedUnits = OperationSpeedUnits.OPS
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: OperationSpeedUnits = OperationSpeedUnits.OPS
	): this(value * unit.multiplier)

	override val enums get() = OperationSpeedUnits.values()
}