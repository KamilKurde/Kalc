package com.kamilKurde.kalc.units.distance

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcType
import com.kamilKurde.kalc.Kalc.UnitDelegate
import com.kamilKurde.kalc.functions.parseNumber

class Transfer internal constructor(
	override var value: BigDecimal
): KalcType<Transfer, TransferUnits>()
{
	override val defaultUnit get() = TransferUnits.BytesPerSecond

	val inJobibytesPerSecond by UnitDelegate(TransferUnits.JobibytesPerSecond.multiplier)
	val inJobibytesPerMinute by UnitDelegate(TransferUnits.JobibytesPerMinute.multiplier)
	val inJobibytesPerHour by UnitDelegate(TransferUnits.JobibytesPerHour.multiplier)

	val inYottabytesPerSecond by UnitDelegate(TransferUnits.YottabytesPerSecond.multiplier)
	val inYottabytesPerMinute by UnitDelegate(TransferUnits.YottabytesPerMinute.multiplier)
	val inYottabytesPerHour by UnitDelegate(TransferUnits.YottabytesPerHour.multiplier)

	val inZebibytesPerSecond by UnitDelegate(TransferUnits.ZebibytesPerSecond.multiplier)
	val inZebibytesPerMinute by UnitDelegate(TransferUnits.ZebibytesPerMinute.multiplier)
	val inZebibytesPerHour by UnitDelegate(TransferUnits.ZebibytesPerHour.multiplier)

	val inZettabytesPerSecond by UnitDelegate(TransferUnits.ZettabytesPerSecond.multiplier)
	val inZettabytesPerMinute by UnitDelegate(TransferUnits.ZettabytesPerMinute.multiplier)
	val inZettabytesPerHour by UnitDelegate(TransferUnits.ZettabytesPerHour.multiplier)

	val inEksbibytesPerSecond by UnitDelegate(TransferUnits.EksbibytesPerSecond.multiplier)
	val inEksbibytesPerMinute by UnitDelegate(TransferUnits.EksbibytesPerMinute.multiplier)
	val inEksbibytesPerHour by UnitDelegate(TransferUnits.EksbibytesPerHour.multiplier)

	val inEksabytesPerSecond by UnitDelegate(TransferUnits.EksabytesPerSecond.multiplier)
	val inEksabytesPerMinute by UnitDelegate(TransferUnits.EksabytesPerMinute.multiplier)
	val inEksabytesPerHour by UnitDelegate(TransferUnits.EksabytesPerHour.multiplier)

	val inPebibytesPerSecond by UnitDelegate(TransferUnits.PebibytesPerSecond.multiplier)
	val inPebibytesPerMinute by UnitDelegate(TransferUnits.PebibytesPerMinute.multiplier)
	val inPebibytesPerHour by UnitDelegate(TransferUnits.PebibytesPerHour.multiplier)

	val inPetabytesPerSecond by UnitDelegate(TransferUnits.PetabytesPerSecond.multiplier)
	val inPetabytesPerMinute by UnitDelegate(TransferUnits.PetabytesPerMinute.multiplier)
	val inPetabytesPerHour by UnitDelegate(TransferUnits.PetabytesPerHour.multiplier)

	val inTebibytesPerSecond by UnitDelegate(TransferUnits.TebibytesPerSecond.multiplier)
	val inTebibytesPerMinute by UnitDelegate(TransferUnits.TebibytesPerMinute.multiplier)
	val inTebibytesPerHour by UnitDelegate(TransferUnits.TebibytesPerHour.multiplier)

	val inTerabytesPerSecond by UnitDelegate(TransferUnits.TerabytesPerSecond.multiplier)
	val inTerabytesPerMinute by UnitDelegate(TransferUnits.TerabytesPerMinute.multiplier)
	val inTerabytesPerHour by UnitDelegate(TransferUnits.TerabytesPerHour.multiplier)

	val inGibibytesPerSecond by UnitDelegate(TransferUnits.GibibytesPerSecond.multiplier)
	val inGibibytesPerMinute by UnitDelegate(TransferUnits.GibibytesPerMinute.multiplier)
	val inGibibytesPerHour by UnitDelegate(TransferUnits.GibibytesPerHour.multiplier)

	val inGigabytesPerSecond by UnitDelegate(TransferUnits.GigabytesPerSecond.multiplier)
	val inGigabytesPerMinute by UnitDelegate(TransferUnits.GigabytesPerMinute.multiplier)
	val inGigabytesPerHour by UnitDelegate(TransferUnits.GigabytesPerHour.multiplier)

	val inMebibytesPerSecond by UnitDelegate(TransferUnits.MebibytesPerSecond.multiplier)
	val inMebibytesPerMinute by UnitDelegate(TransferUnits.MebibytesPerMinute.multiplier)
	val inMebibytesPerHour by UnitDelegate(TransferUnits.MebibytesPerHour.multiplier)

	val inMegabytesPerSecond by UnitDelegate(TransferUnits.MegabytesPerSecond.multiplier)
	val inMegabytesPerMinute by UnitDelegate(TransferUnits.MegabytesPerMinute.multiplier)
	val inMegabytesPerHour by UnitDelegate(TransferUnits.MegabytesPerHour.multiplier)

	val inKibibytesPerSecond by UnitDelegate(TransferUnits.KibibytesPerSecond.multiplier)
	val inKibibytesPerMinute by UnitDelegate(TransferUnits.KibibytesPerMinute.multiplier)
	val inKibibytesPerHour by UnitDelegate(TransferUnits.KibibytesPerHour.multiplier)

	val inKilobytesPerSecond by UnitDelegate(TransferUnits.KilobytesPerSecond.multiplier)
	val inKilobytesPerMinute by UnitDelegate(TransferUnits.KilobytesPerMinute.multiplier)
	val inKilobytesPerHour by UnitDelegate(TransferUnits.KilobytesPerHour.multiplier)

	var inBytesPerSecond by UnitDelegate(BigDecimal.ONE)
	val inBytesPerMinute by UnitDelegate(TransferUnits.BytesPerMinute.multiplier)
	val inBytesPerHour by UnitDelegate(TransferUnits.BytesPerHour.multiplier)

	val inJobibitsPerSecond by UnitDelegate(TransferUnits.JobibitsPerSecond.multiplier)
	val inJobibitsPerMinute by UnitDelegate(TransferUnits.JobibitsPerMinute.multiplier)
	val inJobibitsPerHour by UnitDelegate(TransferUnits.JobibitsPerHour.multiplier)

	val inYottabitsPerSecond by UnitDelegate(TransferUnits.yottabitsPerSecond.multiplier)
	val inYottabitsPerMinute by UnitDelegate(TransferUnits.yottabitsPerMinute.multiplier)
	val inYottabitsPerHour by UnitDelegate(TransferUnits.yottabitsPerHour.multiplier)

	val inZebibitsPerSecond by UnitDelegate(TransferUnits.ZebibitsPerSecond.multiplier)
	val inZebibitsPerMinute by UnitDelegate(TransferUnits.ZebibitsPerMinute.multiplier)
	val inZebibitsPerHour by UnitDelegate(TransferUnits.ZebibitsPerHour.multiplier)

	val inZettabitsPerSecond by UnitDelegate(TransferUnits.ZettabitsPerSecond.multiplier)
	val inZettabitsPerMinute by UnitDelegate(TransferUnits.ZettabitsPerMinute.multiplier)
	val inZettabitsPerHour by UnitDelegate(TransferUnits.ZettabitsPerHour.multiplier)

	val inEksbibitsPerSecond by UnitDelegate(TransferUnits.EksbibitsPerSecond.multiplier)
	val inEksbibitsPerMinute by UnitDelegate(TransferUnits.EksbibitsPerMinute.multiplier)
	val inEksbibitsPerHour by UnitDelegate(TransferUnits.EksbibitsPerHour.multiplier)

	val inEksabitsPerSecond by UnitDelegate(TransferUnits.EksabitsPerSecond.multiplier)
	val inEksabitsPerMinute by UnitDelegate(TransferUnits.EksabitsPerMinute.multiplier)
	val inEksabitsPerHour by UnitDelegate(TransferUnits.EksabitsPerHour.multiplier)

	val inPebibitsPerSecond by UnitDelegate(TransferUnits.PebibitsPerSecond.multiplier)
	val inPebibitsPerMinute by UnitDelegate(TransferUnits.PebibitsPerMinute.multiplier)
	val inPebibitsPerHour by UnitDelegate(TransferUnits.PebibitsPerHour.multiplier)

	val inPetabitsPerSecond by UnitDelegate(TransferUnits.PetabitsPerSecond.multiplier)
	val inPetabitsPerMinute by UnitDelegate(TransferUnits.PetabitsPerMinute.multiplier)
	val inPetabitsPerHour by UnitDelegate(TransferUnits.PetabitsPerHour.multiplier)

	val inTebibitsPerSecond by UnitDelegate(TransferUnits.TebibitsPerSecond.multiplier)
	val inTebibitsPerMinute by UnitDelegate(TransferUnits.TebibitsPerMinute.multiplier)
	val inTebibitsPerHour by UnitDelegate(TransferUnits.TebibitsPerHour.multiplier)

	val inTerabitsPerSecond by UnitDelegate(TransferUnits.TerabitsPerSecond.multiplier)
	val inTerabitsPerMinute by UnitDelegate(TransferUnits.TerabitsPerMinute.multiplier)
	val inTerabitsPerHour by UnitDelegate(TransferUnits.TerabitsPerHour.multiplier)

	val inGibibitsPerSecond by UnitDelegate(TransferUnits.GibibitsPerSecond.multiplier)
	val inGibibitsPerMinute by UnitDelegate(TransferUnits.GibibitsPerMinute.multiplier)
	val inGibibitsPerHour by UnitDelegate(TransferUnits.GibibitsPerHour.multiplier)

	val inGigabitsPerSecond by UnitDelegate(TransferUnits.GigabitsPerSecond.multiplier)
	val inGigabitsPerMinute by UnitDelegate(TransferUnits.GigabitsPerMinute.multiplier)
	val inGigabitsPerHour by UnitDelegate(TransferUnits.GigabitsPerHour.multiplier)

	val inMebibitsPerSecond by UnitDelegate(TransferUnits.MebibitsPerSecond.multiplier)
	val inMebibitsPerMinute by UnitDelegate(TransferUnits.MebibitsPerMinute.multiplier)
	val inMebibitsPerHour by UnitDelegate(TransferUnits.MebibitsPerHour.multiplier)

	val inMegabitsPerSecond by UnitDelegate(TransferUnits.MegabitsPerSecond.multiplier)
	val inMegabitsPerMinute by UnitDelegate(TransferUnits.MegabitsPerMinute.multiplier)
	val inMegabitsPerHour by UnitDelegate(TransferUnits.MegabitsPerHour.multiplier)

	val inKibibitsPerSecond by UnitDelegate(TransferUnits.KibibitsPerSecond.multiplier)
	val inKibibitsPerMinute by UnitDelegate(TransferUnits.KibibitsPerMinute.multiplier)
	val inKibibitsPerHour by UnitDelegate(TransferUnits.KibibitsPerHour.multiplier)

	val inKilobitsPerSecond by UnitDelegate(TransferUnits.KilobitsPerSecond.multiplier)
	val inKilobitsPerMinute by UnitDelegate(TransferUnits.KilobitsPerMinute.multiplier)
	val inKilobitsPerHour by UnitDelegate(TransferUnits.KilobitsPerHour.multiplier)

	val inBitsPerSecond by UnitDelegate(TransferUnits.BitsPerSecond.multiplier)
	val inBitsPerMinute by UnitDelegate(TransferUnits.BitsPerMinute.multiplier)
	val inBitsPerHour by UnitDelegate(TransferUnits.BitsPerHour.multiplier)

	override fun getInstance(value: BigDecimal): Transfer = Transfer(value)

	constructor(
		value: Number,
		unit: TransferUnits = TransferUnits.BytesPerSecond
	): this(BigDecimal.parseNumber(value), unit)

	constructor(
		value: BigDecimal,
		unit: TransferUnits = TransferUnits.BytesPerSecond
	): this(value * unit.multiplier)

	override val enums get() = TransferUnits.values()
}