package com.github.KamilKurde.Kalc.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class UnitDelegate<T: KalcType<T>>(private val multiplier: BigDecimal): ReadWriteProperty<T, BigDecimal>
{
	override operator fun getValue(thisRef: T, property: KProperty<*>): BigDecimal = thisRef.component1() / multiplier

	override operator fun setValue(thisRef: T, property: KProperty<*>, value: BigDecimal)
	{
		thisRef.setComponent1(value * multiplier)
	}
}