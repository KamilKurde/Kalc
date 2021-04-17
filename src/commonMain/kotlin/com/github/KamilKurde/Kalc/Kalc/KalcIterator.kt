package com.github.KamilKurde.Kalc.Kalc

class KalcIterator<T: KalcType<T>>(val range: KalcRange<T>, val step: T): Iterator<T>
{
	private var i = range.start as KalcType<T>

	override fun hasNext(): Boolean = range.contains(i + step)

	override fun next(): T = (i + step).also { i = (i + step) }
}