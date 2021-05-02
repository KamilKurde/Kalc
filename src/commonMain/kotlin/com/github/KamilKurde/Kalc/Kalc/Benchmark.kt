package com.github.KamilKurde.Kalc.Kalc

import com.github.KamilKurde.Kalc.functions.getTime
import com.github.KamilKurde.Kalc.units.computations.Operations
import com.github.KamilKurde.Kalc.units.time.Time

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