package com.kamilKurde.kalc.Kalc

import com.kamilKurde.kalc.functions.unaryMinus
import com.soywiz.kbignum.BigNum
import com.soywiz.kbignum.bn

@Suppress("UNCHECKED_CAST")
abstract class KalcType<T, E>(private val defaultUnit: E, private val enums: Array<E>) where T: KalcType<T, E>, E: KalcEnum
{
	internal abstract var value: BigNum

	abstract fun getInstance(value: BigNum): T

	fun getInstance(value: BigNum, unit: E) = getInstance(value * unit.multiplier)

	fun asUnit(unit: E): BigNum = value / unit.multiplier

	operator fun compareTo(other: T) = value.compareTo(other.value)

	val isPositive get() = this.value >= BigNum.ZERO

	fun defaultStep(): T = getInstance(BigNum.ONE)

	operator fun rangeTo(other: T) =
		KalcRange(this as T, other, true)

	infix fun until(other: T) =
		KalcRange(this as T, other, false)

	infix fun downTo(other: T) =
		KalcRange(this as T, other, true, goingUp = false)

	operator fun unaryMinus() = getInstance(-value)

	operator fun plus(other: T): T = getInstance(value + other.value)

	operator fun minus(other: T): T = getInstance(value - other.value)

	operator fun times(number: Number): T = getInstance(value * number.toString().bn)

	operator fun div(other: T) = value / other.value

	operator fun div(number: Number): T = getInstance(value / number.toString().bn)

	operator fun get(asUnit: E) = asUnit(asUnit)

	operator fun set(inUnit: E, value: BigNum)
	{
		this.value = value * inUnit.multiplier
	}

	fun toString(inUnit: E) = "${asUnit(inUnit)} ${inUnit.name}"

	// Returns unit in which numeric part of toString() will be shortest possible
	fun shortestUnit(): E
	{
		// First element of pair is enum value, second is the number of characters it needs to display readable text
		val array = Array(enums.size)
		{
			enums[it] to asUnit(enums[it]).toString().length
		}
		return array.minByOrNull { it.second }?.first ?: defaultUnit
	}

	override fun toString(): String = toString(shortestUnit())

	override fun equals(other: Any?) = try
	{
		value == (other as T).value
	}
	catch (e: Exception)
	{
		false
	}

	fun copy() = getInstance(value)
}