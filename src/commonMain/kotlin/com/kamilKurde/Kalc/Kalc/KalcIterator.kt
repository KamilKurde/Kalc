package com.kamilKurde.kalc.Kalc

class KalcIterator<T, E>(private val range: KalcRange<T, E>, private val step: T): Iterator<T> where T: KalcType<T, E>, E: KalcEnum
{
	private var i = range.start as KalcType<T, E> - step

	private fun incrementI(): T
	{
		i = i as KalcType<T, E> + step
		return i
	}

	override fun hasNext(): Boolean = ((i as KalcType<T, E> + step) in range)

	override fun next(): T = incrementI()
}