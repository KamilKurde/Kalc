package com.kamilKurde.kalc.units.density

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.Kalc.KalcEnum
import com.kamilKurde.kalc.Multipliers

enum class DensityUnits(override val multiplier: BigDecimal): KalcEnum
{
	GramPerCentimeter3(BigDecimal.ONE),
	KilogramPerLitre(BigDecimal.ONE),
	TonePerMeter3(BigDecimal.ONE),
	KilogramPerMeter3(Multipliers.milli),
}