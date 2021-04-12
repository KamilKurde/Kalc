package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertTrue

class SpeedTest
{
	@Test
	fun conversionTest()
	{
		assertTrue(3.6.kilometersPerHour - 1.metersPerSecond < 0.1.metersPerSecond)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(1.knots >= 1.feetPerSecond)
	}
}