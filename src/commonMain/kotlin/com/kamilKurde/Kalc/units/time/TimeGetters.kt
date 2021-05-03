package com.kamilKurde.kalc.units.time

val Number.years get() = Time(this, TimeUnits.Years)
val Number.weeks get() = Time(this, TimeUnits.Weeks)
val Number.days get() = Time(this, TimeUnits.Days)
val Number.hours get() = Time(this, TimeUnits.Hours)
val Number.minutes get() = Time(this, TimeUnits.Minutes)
val Number.seconds get() = Time(this)
val Number.milliseconds get() = Time(this, TimeUnits.Milliseconds)
val Number.nanoseconds get() = Time(this, TimeUnits.Nanoseconds)
val Number.picoseconds get() = Time(this, TimeUnits.Picoseconds)