package com.kamilKurde.kalc.units.distance

val Number.miles get() = Distance(this, DistanceUnits.Miles)
val Number.kilometers get() = Distance(this, DistanceUnits.Kilometers)
val Number.meters get() = Distance(this)
val Number.yards get() = Distance(this, DistanceUnits.Yards)
val Number.feet get() = Distance(this, DistanceUnits.Feet)
val Number.decimeters get() = Distance(this, DistanceUnits.Decimeters)
val Number.inches get() = Distance(this, DistanceUnits.Inches)
val Number.centimeters get() = Distance(this, DistanceUnits.Centimeters)
val Number.millimeters get() = Distance(this, DistanceUnits.Millimeters)
val Number.nanometers get() = Distance(this, DistanceUnits.Nanometers)
val Number.picometers get() = Distance(this, DistanceUnits.Picometers)