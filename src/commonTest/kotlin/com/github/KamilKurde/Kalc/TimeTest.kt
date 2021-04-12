package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TimeTest
{
	@Test
	fun conversionTest()
	{
		assertEquals(2.hours, 120.minutes)
		assertEquals(4.weeks, 28.days)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(1.hours >= 59.minutes + 60.seconds)
	}
}