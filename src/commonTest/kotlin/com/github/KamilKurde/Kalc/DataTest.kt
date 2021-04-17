package com.github.KamilKurde.Kalc

import com.github.KamilKurde.Kalc.units.data.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DataTest
{
	@Test
	fun conversionTest()
	{
		assertEquals(1.terabytes, 1000.gigabytes)
		assertEquals(1.tebibytes, 1024.gibibytes)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(1.terabytes - 931.32257461548.gibibytes < 1.bytes)
	}
}