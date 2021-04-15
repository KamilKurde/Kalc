package com.github.KamilKurde.Kalc.units.volume

class VolumeRange(val start: Volume, val end: Volume)
{
	operator fun contains(volume: Volume) =
		volume >= start && volume <= end
}