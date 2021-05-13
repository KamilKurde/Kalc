package com.kamilKurde.kalc.units.area

val Number.kilometers2 get() = Area(this, AreaUnits.Kilometers2)
val Number.meters2 get() = Area(this)
val Number.decimeters2 get() = Area(this, AreaUnits.Decimeters2)
val Number.centimeters2 get() = Area(this, AreaUnits.Centimeters2)
val Number.millimeters2 get() = Area(this, AreaUnits.Millimeters2)
val Number.nanometers2 get() = Area(this, AreaUnits.Nanometers2)
val Number.picometers2 get() = Area(this, AreaUnits.Picometers2)