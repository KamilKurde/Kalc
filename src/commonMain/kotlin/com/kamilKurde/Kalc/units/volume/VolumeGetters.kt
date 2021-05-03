package com.kamilKurde.kalc.units.volume

val Number.megalitres get() = Volume(this, VolumeUnits.Megalitres)
val Number.kilometers3 get() = Volume(this, VolumeUnits.Kilometers3)
val Number.meters3 get() = Volume(this)
val Number.barrels get() = Volume(this, VolumeUnits.Barrels)
val Number.liters get() = Volume(this, VolumeUnits.Liters)
val Number.decimeters3 get() = this.liters
val Number.milliliters get() = Volume(this, VolumeUnits.Milliliters)
val Number.centimeters3 get() = this.milliliters