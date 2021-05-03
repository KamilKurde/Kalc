package com.kamilKurde.kalc

import com.kamilKurde.kalc.units.distance.Distance
import com.kamilKurde.kalc.units.volume.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class VolumeTest
{
	private val poolArea = Distance(50) * (Distance(2.5) * 10)
	private val poolVolume = Distance(2) * poolArea

	@Test
	fun conversionTest()
	{
		assertEquals(poolVolume, 2500.meters3)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(poolVolume > 1.barrels)
		assertEquals(poolVolume, Volume(2500))
		assertEquals(1.liters, 1000.centimeters3)
		assertEquals(1.liters, 0.001.meters3)
		assertEquals(1.megalitres, 1000.meters3)
	}
}