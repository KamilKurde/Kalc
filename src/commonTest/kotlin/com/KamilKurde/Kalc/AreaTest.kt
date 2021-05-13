package com.kamilKurde.kalc

import com.kamilKurde.kalc.units.area.centimeters2
import com.kamilKurde.kalc.units.area.kilometers2
import com.kamilKurde.kalc.units.distance.Distance
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AreaTest
{
	private val pool = Distance(50) * (Distance(2.5) * 10)

	@Test
	fun conversionTest()
	{
		assertEquals(pool, 0.001250000.kilometers2)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(pool < 1.kilometers2)
		assertTrue(pool in 1.centimeters2..1.kilometers2)
		assertEquals(pool, 12500000.centimeters2)
	}
}