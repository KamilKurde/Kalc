package com.github.KamilKurde.Kalc.Kalc

class KalcIterator<T>(private val range: KalcRange<T>, private val step: T): Iterator<T> where T: KalcType<T>
{
	private var i = range.start as KalcType<T> - step

	private fun incrementI(): T
	{
		i = i as KalcType<T> + step
		return i
	}

	override fun hasNext(): Boolean = ((i as KalcType<T> + step) in range)

	override fun next(): T = incrementI()
}