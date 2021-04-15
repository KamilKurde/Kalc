package com.github.KamilKurde.Kalc.units.distance

class DistanceRange(val start: Distance, val end: Distance)
{
	operator fun contains(distance: Distance) =
		distance >= start && distance <= end
}