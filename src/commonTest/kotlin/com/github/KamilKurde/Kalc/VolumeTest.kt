package com.github.KamilKurde.Kalc

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
		assertEquals(poolVolume, 2500.m3)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(poolVolume > 1.barrel)
		assertEquals(poolVolume, Volume(2500))
	}
}