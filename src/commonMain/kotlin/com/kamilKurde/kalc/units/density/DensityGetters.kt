package com.kamilKurde.kalc.units.density

val Number.kilogramsPerMeter3 get() = Density(this, DensityUnits.KilogramPerMeter3)
val Number.gramsPerCentimeter3 get() = Density(this)
val Number.kilogramsPerLitre get() = Density(this, DensityUnits.KilogramPerLitre)
val Number.tonesPerMeter3 get() = Density(this, DensityUnits.TonePerMeter3)