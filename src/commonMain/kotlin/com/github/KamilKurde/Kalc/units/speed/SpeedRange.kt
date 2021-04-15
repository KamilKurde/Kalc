package com.github.KamilKurde.Kalc.units.speed

class SpeedRange(val start: Speed, val end: Speed)
{
	operator fun contains(speed: Speed) =
		speed >= start && speed <= end
}