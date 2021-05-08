package com.kamilKurde.kalc.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.kamilKurde.kalc.functions.parseNumber

@Suppress("UNCHECKED_CAST")
abstract class KalcType<T, E> where T: KalcType<T, E>, E: KalcEnum
{
	protected abstract fun component1(): BigDecimal
	protected abstract fun setComponent1(value: BigDecimal)
	var value: BigDecimal
		get() = component1()
		set(value) = setComponent1(value)

	protected abstract val defaultUnit: E

	abstract fun getInstance(value: BigDecimal): T

	fun getInstance(value: BigDecimal, unit: E) = getInstance(value * unit.multiplier)

	fun asUnit(unit: E): BigDecimal = value * unit.multiplier

	operator fun compareTo(other: T) = value.compareTo(other.value)

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

	operator fun get(asUnit: E) = asUnit(asUnit)

	operator fun set(inUnit: E, value: BigDecimal)
	{
		this.value = value * inUnit.multiplier
	}
}