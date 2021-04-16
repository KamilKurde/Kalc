package com.github.KamilKurde.Kalc.Kalc

@Suppress("UNCHECKED_CAST")
class KalcIterator<T: KalcInterface>(val range: KalcRange<T>, val step: T): Iterator<T>
{
	init
	{
		require(step is KalcType<*>) { "\"step\" argument must inherit from KalcType" }
	}

	private var i = range.start as KalcType<T>

	override fun hasNext(): Boolean = range.contains(i + step)

	override fun next(): T = (i + step).also { i = (i + step) as KalcType<T> }
}