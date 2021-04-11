package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class VolumeTest
{
	private val poolArea = Length(50) * (Length(2.5) * 10)
	private val poolVolume = Length(2) * poolArea

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