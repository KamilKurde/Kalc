package com.kamilKurde.kalc.units.mass

val Number.tones get() = Mass(this, MassUnits.Tons)
val Number.slugs get() = Mass(this, MassUnits.Slugs)
val Number.kilograms get() = Mass(this, MassUnits.Kilograms)
val Number.pounds get() = Mass(this, MassUnits.Pounds)
val Number.ounces get() = Mass(this, MassUnits.Ounces)
val Number.decagrams get() = Mass(this, MassUnits.Decagrams)
val Number.grams get() = Mass(this, MassUnits.Grams)
val Number.milligrams get() = Mass(this, MassUnits.Milligrams)