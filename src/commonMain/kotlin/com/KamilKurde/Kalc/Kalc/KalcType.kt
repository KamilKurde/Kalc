package com.kamilKurde.kalc.Kalc

import com.kamilKurde.kalc.functions.parseNumber
import com.kamilKurde.kalc.functions.readable
import com.ionspin.kotlin.bignum.decimal.BigDecimal

@Suppress("UNCHECKED_CAST")
abstract class KalcType<T> where T: KalcType<T>
{
	abstract fun component1(): BigDecimal

	abstract fun setComponent1(value: BigDecimal)

	abstract fun t(value: BigDecimal): T

	operator fun compareTo(other: T) = this.component1().compareTo(other.component1())

	val isPositive get() = this.component1() >= BigDecimal.ZERO

	fun defaultStep(): T = t(BigDecimal.ONE)

	operator fun rangeTo(other: T) =
		KalcRange(this as T, other, true)

	infix fun until(other: T) =
		KalcRange(this as T, other, false)

	infix fun downTo(other: T) =
		KalcRange(this as T, other, true, goingUp = false)

	operator fun unaryMinus() = t(-component1())

	operator fun plus(other: T): T = t(component1() + other.component1())

	operator fun minus(other: T): T = t(component1() - other.component1())

	operator fun times(number: Number): T = t(component1() * BigDecimal.parseNumber(number))

	operator fun div(other: T) = component1() / other.component1()

	operator fun div(number: Number): T = t(component1() / BigDecimal.parseNumber(number))

	operator fun rem(other: T): BigDecimal = component1() % other.component1()

	operator fun rem(number: Number): T = t(component1() % BigDecimal.parseNumber(number))

	operator fun plusAssign(other: T) = setComponent1(component1() + other.component1())

	operator fun minusAssign(other: T) = setComponent1(component1() + other.component1())

	operator fun timesAssign(number: Number) = setComponent1(component1() * BigDecimal.parseNumber(number))

	operator fun divAssign(number: Number) = setComponent1(component1() / BigDecimal.parseNumber(number))

	operator fun remAssign(number: Number) = setComponent1(component1() % BigDecimal.parseNumber(number))

	override fun toString() = this::class.simpleName + "(" + component1().readable() + ")"
}