package com.github.KamilKurde.Kalc.units.time

class TimeRange(val start: Time, val end: Time)
{
	operator fun contains(time: Time) =
		time >= start && time <= end
}