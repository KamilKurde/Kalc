package com.kamilKurde.kalc.units.density

import com.kamilKurde.kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class DensityUnits(val multiplier: BigDecimal)
{
	GramPerCentimeter3(BigDecimal.ONE),
	KilogramPerLitre(BigDecimal.ONE),
	TonePerMeter3(BigDecimal.ONE),
	KilogramPerMeter3(Multipliers.milli),
}