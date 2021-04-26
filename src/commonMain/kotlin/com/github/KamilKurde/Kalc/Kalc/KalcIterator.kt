package com.github.KamilKurde.Kalc.Kalc

@Suppress("UNCHECKED_CAST")
class KalcIterator<T: KalcInterface>(private val range: KalcRange<T>, private val step: T): Iterator<T>
{
	private var i = range.start as KalcType<T> - step

	private fun incrementI(): T
	{
		i = i as KalcType<T> + step
		return i
	}

	override fun hasNext(): Boolean = ((i as KalcType<T> + step) in range).also { println((i as KalcType<T> + step).toString() + " in range " + range.toString() + ": " + range.contains(i as KalcType<T> + step)) }

	override fun next(): T = incrementI()
}