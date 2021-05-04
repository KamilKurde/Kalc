package com.kamilKurde.kalc.units.operationspeed

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.Multipliers
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.units.computations.Operations
import com.kamilKurde.kalc.units.time.Time

data class OperationSpeed(
	var inOPS: BigDecimal,
): KalcType<OperationSpeed>()
{
	var inYOPH by UnitDelegate(Multipliers.yotta)
	var inZOPH by UnitDelegate(Multipliers.zetta)
	var inEOPH by UnitDelegate(Multipliers.exa)
	var inPOPH by UnitDelegate(Multipliers.peta)
	var inTOPH by UnitDelegate(Multipliers.tera)
	var inGOPH by UnitDelegate(Multipliers.giga)
	var inMOPH by UnitDelegate(Multipliers.mega)
	var inKOPH by UnitDelegate(Multipliers.kilo)
	var inYOPM by UnitDelegate(Multipliers.yotta)
	var inZOPM by UnitDelegate(Multipliers.zetta)
	var inEOPM by UnitDelegate(Multipliers.exa)
	var inPOPM by UnitDelegate(Multipliers.peta)
	var inTOPM by UnitDelegate(Multipliers.tera)
	var inGOPM by UnitDelegate(Multipliers.giga)
	var inMOPM by UnitDelegate(Multipliers.mega)
	var inKOPM by UnitDelegate(Multipliers.kilo)
	var inYOPS by UnitDelegate(Multipliers.yotta)
	var inZOPS by UnitDelegate(Multipliers.zetta)
	var inEOPS by UnitDelegate(Multipliers.exa)
	var inPOPS by UnitDelegate(Multipliers.peta)
	var inTOPS by UnitDelegate(Multipliers.tera)
	var inGOPS by UnitDelegate(Multipliers.giga)
	var inMOPS by UnitDelegate(Multipliers.mega)
	var inKOPS by UnitDelegate(Multipliers.kilo)

	operator fun times(time: Time) =
		Operations(inOPS * time.inSeconds)

	override fun setComponent1(value: BigDecimal)
	{
		inOPS = value
	}

	override fun t(value: BigDecimal): OperationSpeed = OperationSpeed(value)

	override fun toString() = super.toString()

	constructor(
		value: Number,
		unit: OperationSpeedUnits = OperationSpeedUnits.OPS
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: OperationSpeedUnits = OperationSpeedUnits.OPS
	): this(value * unit.multiplier)
}