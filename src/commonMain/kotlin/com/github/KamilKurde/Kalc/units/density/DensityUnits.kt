package com.github.KamilKurde.Kalc.units.density

import com.github.KamilKurde.Kalc.Multipliers
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class DensityUnits(val multiplier: BigDecimal)
{
	GramPerCentimeter3(BigDecimal.ONE),
	KilogramPerLitre(BigDecimal.ONE),
	TonePerMeter3(BigDecimal.ONE),
	KilogramPerMeter3(Multipliers.milli),
}