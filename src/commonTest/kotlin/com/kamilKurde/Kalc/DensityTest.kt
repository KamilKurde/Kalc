package com.kamilKurde.kalc

import com.kamilKurde.kalc.units.density.gramsPerCentimeter3
import com.kamilKurde.kalc.units.density.kilogramsPerMeter3
import kotlin.test.Test
import kotlin.test.assertEquals

class DensityTest
{
	private val water = 1000.kilogramsPerMeter3

	@Test
	fun conversionTest()
	{
		assertEquals(water, 1.gramsPerCentimeter3)
	}

	@Test
	fun comparisonTest()
	{
	}
}