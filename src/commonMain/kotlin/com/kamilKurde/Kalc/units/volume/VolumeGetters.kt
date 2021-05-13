package com.kamilKurde.kalc.units.volume

val Number.megalitres get() = Volume(this, VolumeUnits.Megalitres)
val Number.kilometers3 get() = Volume(this, VolumeUnits.Kilometers3)
val Number.meters3 get() = Volume(this, VolumeUnits.Meters3)
val Number.barrels get() = Volume(this, VolumeUnits.Barrels)
val Number.liters get() = Volume(this, VolumeUnits.Liters)
val Number.centimeters3 get() = Volume(this, VolumeUnits.Centimeters3)
val Number.milliliters3 get() = Volume(this, VolumeUnits.Milliliters3)