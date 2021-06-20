package com.kamilKurde.kalc.units.data

import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.units.distance.Transfer
import com.kamilKurde.kalc.units.time.Time
import com.soywiz.kbignum.BigNum

class Data internal constructor(
	override var value: BigNum
): KalcType<Data, DataUnits>(DataUnits.Bytes, DataUnits.values())
{
	var inYobibytes by UnitDelegate(DataUnits.Yobibytes)
	var inYottabytes by UnitDelegate(DataUnits.Yottabytes)
	var inZebibytes by UnitDelegate(DataUnits.Zebibytes)
	var inZettabytes by UnitDelegate(DataUnits.Zettabytes)
	var inExbibytes by UnitDelegate(DataUnits.Exbibytes)
	var inExabytes by UnitDelegate(DataUnits.Exabytes)
	var inPebibytes by UnitDelegate(DataUnits.Pebibytes)
	var inPetabytes by UnitDelegate(DataUnits.Petabytes)
	var inTebibytes by UnitDelegate(DataUnits.Tebibytes)
	var inTerabytes by UnitDelegate(DataUnits.Terabytes)
	var inGibibytes by UnitDelegate(DataUnits.Gibibytes)
	var inGigabytes by UnitDelegate(DataUnits.Gigabytes)
	var inMebibytes by UnitDelegate(DataUnits.Mebibytes)
	var inMegabytes by UnitDelegate(DataUnits.Megabytes)
	var inKibibytes by UnitDelegate(DataUnits.Kibibytes)
	var inKilobytes by UnitDelegate(DataUnits.Kilobytes)
	var inBytes by UnitDelegate(DataUnits.Bytes)
	var inYobibits by UnitDelegate(DataUnits.Yobibits)
	var inYottabits by UnitDelegate(DataUnits.Yottabits)
	var inZebibits by UnitDelegate(DataUnits.Zebibits)
	var inZettabits by UnitDelegate(DataUnits.Zettabits)
	var inExbibits by UnitDelegate(DataUnits.Exbibits)
	var inExabits by UnitDelegate(DataUnits.Exabits)
	var inPebibits by UnitDelegate(DataUnits.Pebibits)
	var inPetabits by UnitDelegate(DataUnits.Petabits)
	var inTebibits by UnitDelegate(DataUnits.Tebibits)
	var inTerabits by UnitDelegate(DataUnits.Terabits)
	var inGibibits by UnitDelegate(DataUnits.Gibibits)
	var inGigabits by UnitDelegate(DataUnits.Gigabits)
	var inMebibits by UnitDelegate(DataUnits.Mebibits)
	var inMegabits by UnitDelegate(DataUnits.Megabits)
	var inKibibits by UnitDelegate(DataUnits.Kibibits)
	var inKilobits by UnitDelegate(DataUnits.Kilobits)
	var inbits by UnitDelegate(DataUnits.Bits)

	operator fun div(time: Time) =
		Transfer(inBytes / time.inSeconds)

	override fun getInstance(value: BigNum): Data = Data(value)

	constructor(
		value: Number,
		unit: DataUnits = DataUnits.Bits
	): this(BigNum(value.toString()), unit)

	constructor(
		value: BigNum,
		unit: DataUnits = DataUnits.Bits
	): this(value * unit.multiplier)
}