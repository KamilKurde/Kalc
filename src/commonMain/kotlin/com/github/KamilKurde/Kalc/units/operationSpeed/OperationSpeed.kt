package com.github.KamilKurde.Kalc.units.OperationSpeed

import com.github.KamilKurde.Kalc.Kalc.KalcType
import com.github.KamilKurde.Kalc.Kalc.UnitDelegate
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.units.computations.Operations
import com.github.KamilKurde.Kalc.units.operationSpeed.OperationSpeedUnits
import com.github.KamilKurde.Kalc.units.time.Time
import com.ionspin.kotlin.bignum.decimal.BigDecimal

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