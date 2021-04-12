package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DistanceTest
{
	private val marathon = Distance(42195)

	@Test
	fun conversionTest()
	{
		assertEquals(marathon, 42.195.kilometers)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(marathon > 1.kilometers)
		assertEquals(marathon, 421950.decimeters)
		assertEquals(1.miles, 5280.feet)
	}
}