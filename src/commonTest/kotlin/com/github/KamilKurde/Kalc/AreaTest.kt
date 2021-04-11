package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AreaTest
{
	private val pool = length(50) * (length(2.5) * 10)

	@Test
	fun conversionTest()
	{
		assertEquals(pool, 0.001250000.km2)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(pool < 1.km2)
		assertEquals(pool, 12500000.cm2)
	}
}