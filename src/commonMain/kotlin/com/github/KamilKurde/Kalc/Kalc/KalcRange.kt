package com.github.KamilKurde.Kalc.Kalc

@Suppress("UNCHECKED_CAST")
class KalcRange<T: KalcInterface>(val start: T, val end: T, val inclusive: Boolean, private val step: T = (start as KalcType<T>).defaultStep(), private val goingUp: Boolean = true): Iterable<T>
{
	init
	{
		require(step.isPositive) { "Step must be positive, was $step" }
	}

	private val downBound = if (goingUp) start else end
	private val upperBound = if (goingUp) end else start

	operator fun contains(other: T) =
		other >= downBound && (other < upperBound || if (inclusive) other == upperBound else false)

	override fun iterator(): Iterator<T> =
		KalcIterator(this, if (goingUp) step else -(step as KalcType<T>))

	infix fun step(step: T): Iterable<T> =
		KalcRange(start, end, inclusive, step, goingUp)

	override fun toString(): String = "$start to $end, inclusive: $inclusive, step: $step, goingUp: $goingUp"
}