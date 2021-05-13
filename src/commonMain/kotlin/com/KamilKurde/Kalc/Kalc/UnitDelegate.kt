package com.kamilKurde.kalc.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class UnitDelegate<T, E>(private val unit: E): ReadWriteProperty<T, BigDecimal> where T: KalcType<T, E>, E: KalcEnum
{
	override operator fun getValue(thisRef: T, property: KProperty<*>): BigDecimal = thisRef[unit]

	override operator fun setValue(thisRef: T, property: KProperty<*>, value: BigDecimal)
	{
		thisRef[unit] = value
	}
}