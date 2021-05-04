package com.kamilKurde.kalc.Kalc

import com.kamilKurde.kalc.functions.getTime
import com.kamilKurde.kalc.units.operations.Operations
import com.kamilKurde.kalc.units.time.Time

data class Benchmark(val duration: Time, val operations: Operations)
{
	companion object
	{
		fun test(operationsNumber: Operations, exec: () -> Unit): Benchmark
		{
			val start = getTime()
			exec()
			val stop = getTime()
			return Benchmark(stop - start, operationsNumber)
		}
	}

	val operationSpeed get() = operations / duration
}