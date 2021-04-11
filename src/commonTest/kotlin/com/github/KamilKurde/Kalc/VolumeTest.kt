package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class VolumeTest
{
	private val poolArea = length(50) * (length(2.5) * 10)
	private val poolVolume = poolArea * length(2)

	@Test
	fun conversionTest()
	{
		assertEquals(poolVolume, 2500.m3)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(poolVolume > 1.barrel)
		assertEquals(poolVolume, volume(2500))
	}
}