package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertTrue

class SpeedTest
{
	@Test
	fun conversionTest()
	{
		assertTrue(3.6.kmph - 1.mps < 0.1.mps)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(1.knots >= 1.fps)
	}
}