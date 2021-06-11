package com.kamilKurde.kalc

import com.kamilKurde.kalc.Kalc.Benchmark
import com.kamilKurde.kalc.units.distance.*
import com.kamilKurde.kalc.units.operations.operations
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DistanceTest
{
	private val marathon = Distance(42195)

	@Test
	fun conversionTest()
	{
		assertEquals(marathon, 42.195.kilometers)
	}

	@Test
	fun comparisonTest()
	{
		assertTrue(marathon > 1.kilometers)
		assertEquals(marathon, 421950.decimeters)
		assertEquals(1.miles, 5280.feet)
	}

	@Test
	fun performanceTest()
	{
		println(Benchmark(10000.operations){
			Distance(
				Random.nextInt(),
				DistanceUnits.values().random())[DistanceUnits.values().random()]
		})
	}
}