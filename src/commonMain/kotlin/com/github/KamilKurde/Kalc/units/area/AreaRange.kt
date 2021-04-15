package com.github.KamilKurde.Kalc.units.area

class AreaRange(val start: Area, val end: Area)
{
	operator fun contains(area: Area) =
		area >= start && area <= end
}