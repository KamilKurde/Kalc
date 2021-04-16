package com.github.KamilKurde.Kalc.Kalc

import com.github.KamilKurde.Kalc.functions.parseNumber
import com.github.KamilKurde.Kalc.functions.readable
import com.ionspin.kotlin.bignum.decimal.BigDecimal

// FOR USE ONLY ON CLASSES INHERITING AFTER KalcType
interface KalcInterface
{
	fun component1(): BigDecimal

	fun setComponent1(value: BigDecimal)

	operator fun compareTo(other: KalcInterface) = this.component1().compareTo(other.component1())
}

@Suppress("UNCHECKED_CAST")
abstract class KalcType<T: KalcInterface>: KalcInterface
{
	abstract fun t(value: BigDecimal): T

	fun defaultStep(): T = t(BigDecimal.ONE)

	operator fun rangeTo(other: T) =
		KalcRange(this as T, other, true)

	infix fun until(other: T) =
		KalcRange(this as T, other, false)

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