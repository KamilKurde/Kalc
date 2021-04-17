package com.github.KamilKurde.Kalc.Kalc

@Suppress("UNCHECKED_CAST")
class KalcRange<T: KalcInterface>(val start: T, val end: T, val inclusive: Boolean, private val step: T = (start as KalcType<T>).defaultStep()): Iterable<T>
{
	init
	{
		require(end >= start) { "\"end\" must have higher value than \"start\"" }
	}

	operator fun contains(other: T) =
		other >= start && if (inclusive) other <= end else other < end

	override fun iterator(): Iterator<T> =
		KalcIterator(this, step)

	infix fun step(t: T): Iterable<T> =
		KalcRange(start, end, inclusive, t)
}