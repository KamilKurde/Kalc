package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LengthTest
{
	private val marathon = Distance(42195)

	@Test
	fun conversionTest()
	{
		assertEquals(marathon, 42.195.km)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(marathon > 1.km)
		assertEquals(marathon, 421950.dm)
	}
}