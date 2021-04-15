package com.github.KamilKurde.Kalc

import com.github.KamilKurde.Kalc.units.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MassTest
{
	@Test
	fun conversionTest()
	{
		assertEquals(1.pounds, 16.ounces)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(1.kilograms > 35.ounces)
		assertTrue(69.slugs > 1.tones)
		assertEquals(1.tones, 1_000.kilograms)
	}
}