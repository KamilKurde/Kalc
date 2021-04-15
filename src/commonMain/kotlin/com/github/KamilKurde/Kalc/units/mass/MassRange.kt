package com.github.KamilKurde.Kalc.units.mass

class MassRange(val start: Mass, val end: Mass)
{
	operator fun contains(mass: Mass) =
		mass >= start && mass <= end
}