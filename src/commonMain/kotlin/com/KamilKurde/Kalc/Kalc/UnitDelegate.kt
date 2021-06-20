package com.kamilKurde.kalc.Kalc

import com.soywiz.kbignum.BigNum
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class UnitDelegate<T, E>(private val unit: E): ReadWriteProperty<T, BigNum> where T: KalcType<T, E>, E: KalcEnum
{
	override operator fun getValue(thisRef: T, property: KProperty<*>): BigNum = thisRef[unit]

	override operator fun setValue(thisRef: T, property: KProperty<*>, value: BigNum)
	{
		thisRef[unit] = value
	}
}