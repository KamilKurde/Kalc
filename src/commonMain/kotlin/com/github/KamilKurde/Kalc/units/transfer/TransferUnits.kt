package com.github.KamilKurde.Kalc.units.distance

import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class TransferUnits(val multiplier: BigDecimal)
{
	JobibytesPerSecond(Multipliers.jobi),
	JobibytesPerMinute(JobibytesPerSecond.multiplier * Multipliers.minute),
	JobibytesPerHour(JobibytesPerSecond.multiplier * Multipliers.hour),

	JottabytesPerSecond(Multipliers.jotta),
	JottabytesPerMinute(JottabytesPerSecond.multiplier * Multipliers.minute),
	JottabytesPerHour(JottabytesPerSecond.multiplier * Multipliers.hour),

	ZebibytesPerSecond(Multipliers.zebi),
	ZebibytesPerMinute(ZebibytesPerSecond.multiplier * Multipliers.minute),
	ZebibytesPerHour(ZebibytesPerSecond.multiplier * Multipliers.hour),

	ZettabytesPerSecond(Multipliers.zetta),
	ZettabytesPerMinute(ZettabytesPerSecond.multiplier * Multipliers.minute),
	ZettabytesPerHour(ZettabytesPerSecond.multiplier * Multipliers.hour),

	EksbibytesPerSecond(Multipliers.eksbi),
	EksbibytesPerMinute(EksbibytesPerSecond.multiplier * Multipliers.minute),
	EksbibytesPerHour(EksbibytesPerSecond.multiplier * Multipliers.hour),

	EksabytesPerSecond(Multipliers.eksa),
	EksabytesPerMinute(EksabytesPerSecond.multiplier * Multipliers.minute),
	EksabytesPerHour(EksabytesPerSecond.multiplier * Multipliers.hour),

	PebibytesPerSecond(Multipliers.pebi),
	PebibytesPerMinute(PebibytesPerSecond.multiplier * Multipliers.minute),
	PebibytesPerHour(PebibytesPerSecond.multiplier * Multipliers.hour),

	PetabytesPerSecond(Multipliers.peta),
	PetabytesPerMinute(PetabytesPerSecond.multiplier * Multipliers.minute),
	PetabytesPerHour(PetabytesPerSecond.multiplier * Multipliers.hour),

	TebibytesPerSecond(Multipliers.tebi),
	TebibytesPerMinute(TebibytesPerSecond.multiplier * Multipliers.minute),
	TebibytesPerHour(TebibytesPerSecond.multiplier * Multipliers.hour),

	TerabytesPerSecond(Multipliers.tera),
	TerabytesPerMinute(TerabytesPerSecond.multiplier * Multipliers.minute),
	TerabytesPerHour(TerabytesPerSecond.multiplier * Multipliers.hour),

	GibibytesPerSecond(Multipliers.gibi),
	GibibytesPerMinute(GibibytesPerSecond.multiplier * Multipliers.minute),
	GibibytesPerHour(GibibytesPerSecond.multiplier * Multipliers.hour),

	GigabytesPerSecond(Multipliers.giga),
	GigabytesPerMinute(GigabytesPerSecond.multiplier * Multipliers.minute),
	GigabytesPerHour(GigabytesPerSecond.multiplier * Multipliers.hour),

	MebibytesPerSecond(Multipliers.mebi),
	MebibytesPerMinute(MebibytesPerSecond.multiplier * Multipliers.minute),
	MebibytesPerHour(MebibytesPerSecond.multiplier * Multipliers.hour),

	MegabytesPerSecond(Multipliers.mega),
	MegabytesPerMinute(MegabytesPerSecond.multiplier * Multipliers.minute),
	MegabytesPerHour(MegabytesPerSecond.multiplier * Multipliers.hour),

	KibibytesPerSecond(Multipliers.kibi),
	KibibytesPerMinute(KibibytesPerSecond.multiplier * Multipliers.minute),
	KibibytesPerHour(KibibytesPerSecond.multiplier * Multipliers.hour),

	KilobytesPerSecond(Multipliers.kilo),
	KilobytesPerMinute(KilobytesPerSecond.multiplier * Multipliers.minute),
	KilobytesPerHour(KilobytesPerSecond.multiplier * Multipliers.hour),

	BytesPerSecond(BigDecimal.ONE),
	BytesPerMinute(BytesPerSecond.multiplier * Multipliers.minute),
	BytesPerHour(BytesPerSecond.multiplier * Multipliers.hour),

	JobibitsPerSecond(Multipliers.jobi * Multipliers.bit),
	JobibitsPerMinute(JobibitsPerSecond.multiplier * Multipliers.minute),
	JobibitsPerHour(JobibitsPerSecond.multiplier * Multipliers.hour),

	JottabitsPerSecond(Multipliers.jotta * Multipliers.bit),
	JottabitsPerMinute(JottabitsPerSecond.multiplier * Multipliers.minute),
	JottabitsPerHour(JottabitsPerSecond.multiplier * Multipliers.hour),

	ZebibitsPerSecond(Multipliers.zebi * Multipliers.bit),
	ZebibitsPerMinute(ZebibitsPerSecond.multiplier * Multipliers.minute),
	ZebibitsPerHour(ZebibitsPerSecond.multiplier * Multipliers.hour),

	ZettabitsPerSecond(Multipliers.zetta * Multipliers.bit),
	ZettabitsPerMinute(ZettabitsPerSecond.multiplier * Multipliers.minute),
	ZettabitsPerHour(ZettabitsPerSecond.multiplier * Multipliers.hour),

	EksbibitsPerSecond(Multipliers.eksbi * Multipliers.bit),
	EksbibitsPerMinute(EksbibitsPerSecond.multiplier * Multipliers.minute),
	EksbibitsPerHour(EksbibitsPerSecond.multiplier * Multipliers.hour),

	EksabitsPerSecond(Multipliers.eksa * Multipliers.bit),
	EksabitsPerMinute(EksabitsPerSecond.multiplier * Multipliers.minute),
	EksabitsPerHour(EksabitsPerSecond.multiplier * Multipliers.hour),

	PebibitsPerSecond(Multipliers.pebi * Multipliers.bit),
	PebibitsPerMinute(PebibitsPerSecond.multiplier * Multipliers.minute),
	PebibitsPerHour(PebibitsPerSecond.multiplier * Multipliers.hour),

	PetabitsPerSecond(Multipliers.peta * Multipliers.bit),
	PetabitsPerMinute(PetabitsPerSecond.multiplier * Multipliers.minute),
	PetabitsPerHour(PetabitsPerSecond.multiplier * Multipliers.hour),

	TebibitsPerSecond(Multipliers.tebi * Multipliers.bit),
	TebibitsPerMinute(TebibitsPerSecond.multiplier * Multipliers.minute),
	TebibitsPerHour(TebibitsPerSecond.multiplier * Multipliers.hour),

	TerabitsPerSecond(Multipliers.tera * Multipliers.bit),
	TerabitsPerMinute(TerabitsPerSecond.multiplier * Multipliers.minute),
	TerabitsPerHour(TerabitsPerSecond.multiplier * Multipliers.hour),

	GibibitsPerSecond(Multipliers.gibi * Multipliers.bit),
	GibibitsPerMinute(GibibitsPerSecond.multiplier * Multipliers.minute),
	GibibitsPerHour(GibibitsPerSecond.multiplier * Multipliers.hour),

	GigabitsPerSecond(Multipliers.giga * Multipliers.bit),
	GigabitsPerMinute(GigabitsPerSecond.multiplier * Multipliers.minute),
	GigabitsPerHour(GigabitsPerSecond.multiplier * Multipliers.hour),

	MebibitsPerSecond(Multipliers.mebi * Multipliers.bit),
	MebibitsPerMinute(MebibitsPerSecond.multiplier * Multipliers.minute),
	MebibitsPerHour(MebibitsPerSecond.multiplier * Multipliers.hour),

	MegabitsPerSecond(Multipliers.mega * Multipliers.bit),
	MegabitsPerMinute(MegabitsPerSecond.multiplier * Multipliers.minute),
	MegabitsPerHour(MegabitsPerSecond.multiplier * Multipliers.hour),

	KibibitsPerSecond(Multipliers.kibi * Multipliers.bit),
	KibibitsPerMinute(KibibitsPerSecond.multiplier * Multipliers.minute),
	KibibitsPerHour(KibibitsPerSecond.multiplier * Multipliers.hour),

	KilobitsPerSecond(Multipliers.kilo * Multipliers.bit),
	KilobitsPerMinute(KilobitsPerSecond.multiplier * Multipliers.minute),
	KilobitsPerHour(KilobitsPerSecond.multiplier * Multipliers.hour),

	BitsPerSecond(Multipliers.bit),
	BitsPerMinute(BitsPerSecond.multiplier * Multipliers.minute),
	BitsPerHour(BitsPerSecond.multiplier * Multipliers.hour),
}