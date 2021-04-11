package com.github.KamilKurde.Kalc

import kotlin.test.Test
import kotlin.test.assertEquals

class LengthTest
{
	@Test
	fun testConversion()
	{
		val marathon = Length(42195)
		assertEquals(marathon, 42.195.km)
	}
}