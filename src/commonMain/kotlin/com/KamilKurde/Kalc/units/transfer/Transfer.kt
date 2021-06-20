package com.kamilKurde.kalc.units.distance

import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.soywiz.kbignum.BigNum

class Transfer internal constructor(
	override var value: BigNum
): KalcType<Transfer, TransferUnits>(TransferUnits.BytesPerSecond, TransferUnits.values())
{
	val inJobibytesPerSecond by UnitDelegate(TransferUnits.JobibytesPerSecond)
	val inJobibytesPerMinute by UnitDelegate(TransferUnits.JobibytesPerMinute)
	val inJobibytesPerHour by UnitDelegate(TransferUnits.JobibytesPerHour)

	val inYottabytesPerSecond by UnitDelegate(TransferUnits.YottabytesPerSecond)
	val inYottabytesPerMinute by UnitDelegate(TransferUnits.YottabytesPerMinute)
	val inYottabytesPerHour by UnitDelegate(TransferUnits.YottabytesPerHour)

	val inZebibytesPerSecond by UnitDelegate(TransferUnits.ZebibytesPerSecond)
	val inZebibytesPerMinute by UnitDelegate(TransferUnits.ZebibytesPerMinute)
	val inZebibytesPerHour by UnitDelegate(TransferUnits.ZebibytesPerHour)

	val inZettabytesPerSecond by UnitDelegate(TransferUnits.ZettabytesPerSecond)
	val inZettabytesPerMinute by UnitDelegate(TransferUnits.ZettabytesPerMinute)
	val inZettabytesPerHour by UnitDelegate(TransferUnits.ZettabytesPerHour)

	val inEksbibytesPerSecond by UnitDelegate(TransferUnits.EksbibytesPerSecond)
	val inEksbibytesPerMinute by UnitDelegate(TransferUnits.EksbibytesPerMinute)
	val inEksbibytesPerHour by UnitDelegate(TransferUnits.EksbibytesPerHour)

	val inEksabytesPerSecond by UnitDelegate(TransferUnits.EksabytesPerSecond)
	val inEksabytesPerMinute by UnitDelegate(TransferUnits.EksabytesPerMinute)
	val inEksabytesPerHour by UnitDelegate(TransferUnits.EksabytesPerHour)

	val inPebibytesPerSecond by UnitDelegate(TransferUnits.PebibytesPerSecond)
	val inPebibytesPerMinute by UnitDelegate(TransferUnits.PebibytesPerMinute)
	val inPebibytesPerHour by UnitDelegate(TransferUnits.PebibytesPerHour)

	val inPetabytesPerSecond by UnitDelegate(TransferUnits.PetabytesPerSecond)
	val inPetabytesPerMinute by UnitDelegate(TransferUnits.PetabytesPerMinute)
	val inPetabytesPerHour by UnitDelegate(TransferUnits.PetabytesPerHour)

	val inTebibytesPerSecond by UnitDelegate(TransferUnits.TebibytesPerSecond)
	val inTebibytesPerMinute by UnitDelegate(TransferUnits.TebibytesPerMinute)
	val inTebibytesPerHour by UnitDelegate(TransferUnits.TebibytesPerHour)

	val inTerabytesPerSecond by UnitDelegate(TransferUnits.TerabytesPerSecond)
	val inTerabytesPerMinute by UnitDelegate(TransferUnits.TerabytesPerMinute)
	val inTerabytesPerHour by UnitDelegate(TransferUnits.TerabytesPerHour)

	val inGibibytesPerSecond by UnitDelegate(TransferUnits.GibibytesPerSecond)
	val inGibibytesPerMinute by UnitDelegate(TransferUnits.GibibytesPerMinute)
	val inGibibytesPerHour by UnitDelegate(TransferUnits.GibibytesPerHour)

	val inGigabytesPerSecond by UnitDelegate(TransferUnits.GigabytesPerSecond)
	val inGigabytesPerMinute by UnitDelegate(TransferUnits.GigabytesPerMinute)
	val inGigabytesPerHour by UnitDelegate(TransferUnits.GigabytesPerHour)

	val inMebibytesPerSecond by UnitDelegate(TransferUnits.MebibytesPerSecond)
	val inMebibytesPerMinute by UnitDelegate(TransferUnits.MebibytesPerMinute)
	val inMebibytesPerHour by UnitDelegate(TransferUnits.MebibytesPerHour)

	val inMegabytesPerSecond by UnitDelegate(TransferUnits.MegabytesPerSecond)
	val inMegabytesPerMinute by UnitDelegate(TransferUnits.MegabytesPerMinute)
	val inMegabytesPerHour by UnitDelegate(TransferUnits.MegabytesPerHour)

	val inKibibytesPerSecond by UnitDelegate(TransferUnits.KibibytesPerSecond)
	val inKibibytesPerMinute by UnitDelegate(TransferUnits.KibibytesPerMinute)
	val inKibibytesPerHour by UnitDelegate(TransferUnits.KibibytesPerHour)

	val inKilobytesPerSecond by UnitDelegate(TransferUnits.KilobytesPerSecond)
	val inKilobytesPerMinute by UnitDelegate(TransferUnits.KilobytesPerMinute)
	val inKilobytesPerHour by UnitDelegate(TransferUnits.KilobytesPerHour)

	var inBytesPerSecond by UnitDelegate(TransferUnits.BytesPerSecond)
	val inBytesPerMinute by UnitDelegate(TransferUnits.BytesPerMinute)
	val inBytesPerHour by UnitDelegate(TransferUnits.BytesPerHour)

	val inJobibitsPerSecond by UnitDelegate(TransferUnits.JobibitsPerSecond)
	val inJobibitsPerMinute by UnitDelegate(TransferUnits.JobibitsPerMinute)
	val inJobibitsPerHour by UnitDelegate(TransferUnits.JobibitsPerHour)

	val inYottabitsPerSecond by UnitDelegate(TransferUnits.yottabitsPerSecond)
	val inYottabitsPerMinute by UnitDelegate(TransferUnits.yottabitsPerMinute)
	val inYottabitsPerHour by UnitDelegate(TransferUnits.yottabitsPerHour)

	val inZebibitsPerSecond by UnitDelegate(TransferUnits.ZebibitsPerSecond)
	val inZebibitsPerMinute by UnitDelegate(TransferUnits.ZebibitsPerMinute)
	val inZebibitsPerHour by UnitDelegate(TransferUnits.ZebibitsPerHour)

	val inZettabitsPerSecond by UnitDelegate(TransferUnits.ZettabitsPerSecond)
	val inZettabitsPerMinute by UnitDelegate(TransferUnits.ZettabitsPerMinute)
	val inZettabitsPerHour by UnitDelegate(TransferUnits.ZettabitsPerHour)

	val inEksbibitsPerSecond by UnitDelegate(TransferUnits.EksbibitsPerSecond)
	val inEksbibitsPerMinute by UnitDelegate(TransferUnits.EksbibitsPerMinute)
	val inEksbibitsPerHour by UnitDelegate(TransferUnits.EksbibitsPerHour)

	val inEksabitsPerSecond by UnitDelegate(TransferUnits.EksabitsPerSecond)
	val inEksabitsPerMinute by UnitDelegate(TransferUnits.EksabitsPerMinute)
	val inEksabitsPerHour by UnitDelegate(TransferUnits.EksabitsPerHour)

	val inPebibitsPerSecond by UnitDelegate(TransferUnits.PebibitsPerSecond)
	val inPebibitsPerMinute by UnitDelegate(TransferUnits.PebibitsPerMinute)
	val inPebibitsPerHour by UnitDelegate(TransferUnits.PebibitsPerHour)

	val inPetabitsPerSecond by UnitDelegate(TransferUnits.PetabitsPerSecond)
	val inPetabitsPerMinute by UnitDelegate(TransferUnits.PetabitsPerMinute)
	val inPetabitsPerHour by UnitDelegate(TransferUnits.PetabitsPerHour)

	val inTebibitsPerSecond by UnitDelegate(TransferUnits.TebibitsPerSecond)
	val inTebibitsPerMinute by UnitDelegate(TransferUnits.TebibitsPerMinute)
	val inTebibitsPerHour by UnitDelegate(TransferUnits.TebibitsPerHour)

	val inTerabitsPerSecond by UnitDelegate(TransferUnits.TerabitsPerSecond)
	val inTerabitsPerMinute by UnitDelegate(TransferUnits.TerabitsPerMinute)
	val inTerabitsPerHour by UnitDelegate(TransferUnits.TerabitsPerHour)

	val inGibibitsPerSecond by UnitDelegate(TransferUnits.GibibitsPerSecond)
	val inGibibitsPerMinute by UnitDelegate(TransferUnits.GibibitsPerMinute)
	val inGibibitsPerHour by UnitDelegate(TransferUnits.GibibitsPerHour)

	val inGigabitsPerSecond by UnitDelegate(TransferUnits.GigabitsPerSecond)
	val inGigabitsPerMinute by UnitDelegate(TransferUnits.GigabitsPerMinute)
	val inGigabitsPerHour by UnitDelegate(TransferUnits.GigabitsPerHour)

	val inMebibitsPerSecond by UnitDelegate(TransferUnits.MebibitsPerSecond)
	val inMebibitsPerMinute by UnitDelegate(TransferUnits.MebibitsPerMinute)
	val inMebibitsPerHour by UnitDelegate(TransferUnits.MebibitsPerHour)

	val inMegabitsPerSecond by UnitDelegate(TransferUnits.MegabitsPerSecond)
	val inMegabitsPerMinute by UnitDelegate(TransferUnits.MegabitsPerMinute)
	val inMegabitsPerHour by UnitDelegate(TransferUnits.MegabitsPerHour)

	val inKibibitsPerSecond by UnitDelegate(TransferUnits.KibibitsPerSecond)
	val inKibibitsPerMinute by UnitDelegate(TransferUnits.KibibitsPerMinute)
	val inKibibitsPerHour by UnitDelegate(TransferUnits.KibibitsPerHour)

	val inKilobitsPerSecond by UnitDelegate(TransferUnits.KilobitsPerSecond)
	val inKilobitsPerMinute by UnitDelegate(TransferUnits.KilobitsPerMinute)
	val inKilobitsPerHour by UnitDelegate(TransferUnits.KilobitsPerHour)

	val inBitsPerSecond by UnitDelegate(TransferUnits.BitsPerSecond)
	val inBitsPerMinute by UnitDelegate(TransferUnits.BitsPerMinute)
	val inBitsPerHour by UnitDelegate(TransferUnits.BitsPerHour)

	override fun getInstance(value: BigNum): Transfer = Transfer(value)

	constructor(
		value: Number,
		unit: TransferUnits = TransferUnits.BytesPerSecond
	): this(BigNum(value.toString()), unit)

	constructor(
		value: BigNum,
		unit: TransferUnits = TransferUnits.BytesPerSecond
	): this(value * unit.multiplier)
}