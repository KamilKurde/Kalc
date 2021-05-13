package com.kamilKurde.kalc.Kalc

import com.kamilKurde.kalc.functions.getTime
import com.kamilKurde.kalc.units.operations.Operations
import com.kamilKurde.kalc.units.time.Time

data class Benchmark(val duration: Time, val operations: Operations)
{
	companion object
	{
		private fun test(exec: () -> Unit): Time
		{
			val start = getTime()
			exec()
			val stop = getTime()
			return stop - start
		}
	}

	constructor(
		operationsNumber: Operations,
		exec: () -> Unit
	): this(
		test(exec),
		operationsNumber
	)

	val operationSpeed get() = operations / duration
}