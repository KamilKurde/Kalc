package com.kamilKurde.kalc.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.functions.readable

@Suppress("UNCHECKED_CAST")
abstract class KalcType<T> where T: KalcType<T>
{
	abstract var value: BigDecimal

	abstract fun getInstance(value: BigDecimal): T

	operator fun compareTo(other: T) = this.value.compareTo(other.value)

	val isPositive get() = this.value >= BigDecimal.ZERO

	fun defaultStep(): T = getInstance(BigDecimal.ONE)

	operator fun rangeTo(other: T) =
		KalcRange(this as T, other, true)

	infix fun until(other: T) =
		KalcRange(this as T, other, false)

	infix fun downTo(other: T) =
		KalcRange(this as T, other, true, goingUp = false)

	operator fun unaryMinus() = getInstance(-value)

	operator fun plus(other: T): T = getInstance(value + other.value)

	operator fun minus(other: T): T = getInstance(value - other.value)

	operator fun times(number: Number): T = getInstance(value * BigDecimal.parseNumber(number))

	operator fun div(other: T) = value / other.value

	operator fun div(number: Number): T = getInstance(value / BigDecimal.parseNumber(number))

	operator fun rem(other: T): BigDecimal = value % other.value

	operator fun rem(number: Number): T = getInstance(value % BigDecimal.parseNumber(number))

	operator fun plusAssign(other: T)
	{
		value += other.value
	}

	operator fun minusAssign(other: T)
	{
		value += other.value
	}

	operator fun timesAssign(number: Number)
	{
		value *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		value /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		value %= BigDecimal.parseNumber(number)
	}

	override fun toString() = this::class.simpleName + "(" + value.readable() + ")"
}