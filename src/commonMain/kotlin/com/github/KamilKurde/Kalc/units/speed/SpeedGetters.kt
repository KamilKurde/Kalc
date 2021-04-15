package com.github.KamilKurde.Kalc.units.speed

val Number.metersPerSecond get() = Speed(this)
val Number.kilometersPerHour get() = Speed(this, SpeedUnits.KilometersPerHour)
val Number.milesPerHour get() = Speed(this, SpeedUnits.MilesPerHour)
val Number.knots get() = Speed(this, SpeedUnits.Knots)
val Number.feetPerSecond get() = Speed(this, SpeedUnits.FeetPerSecond)