package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TimeTest
{
	@Test
	fun conversionTest()
	{
		assertEquals(2.h, 120.min)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(1.h >= 59.min + 60.s)
	}
}