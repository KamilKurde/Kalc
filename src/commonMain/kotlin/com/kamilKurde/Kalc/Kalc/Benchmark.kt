package com.kamilKurde.kalc.Kalc

import com.kamilKurde.kalc.functions.getTime
import com.kamilKurde.kalc.units.operations.Operations
import com.kamilKurde.kalc.units.time.Time

data class Benchmark(val duration: Time, val operations: Operations)
{
	companion object{
		// Works like constructor
		// First argument is the number of operations (runs)
		// Second argument is the operation to execute
		inline operator fun invoke(
			operationsNumber: Operations,
			exec: () -> Unit
		): Benchmark
		{
			val start = getTime()
			repeat(operationsNumber.inOperations.toStringExpanded().toInt()){
				exec()
			}
			val stop = getTime()
			return Benchmark(stop - start, operationsNumber)
		}
	}

	val operationSpeed get() = operations / duration

	override fun toString() = "Operation number: $operations, Duration: $duration, Operation speed: $operationSpeed"
}