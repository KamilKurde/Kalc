package com.kamilKurde.kalc.units.density

import com.soywiz.kbignum.BigNum
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class DensityUnits(override val multiplier: BigNum): KalcEnum
{
	GramPerCentimeter3(BigNum.ONE),
	KilogramPerLitre(BigNum.ONE),
	TonePerMeter3(BigNum.ONE),
	KilogramPerMeter3(Multipliers.milli),
}