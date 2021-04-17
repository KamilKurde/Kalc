package com.github.KamilKurde.Kalc

import com.github.KamilKurde.Kalc.units.area.*
import com.github.KamilKurde.Kalc.units.distance.Distance
import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
		assertEquals(1.miles2, 27_878_400.feet2)
		assertEquals(1.miles2, Area(BigDecimal.parseString("2.589988110336"), AreaUnits.Kilometers2))
	}
}