package com.kamilKurde.kalc.functions

import com.soywiz.kbignum.BigNum

//Operator funs
operator fun BigNum.unaryMinus() = BigNum(-int, scale)

// Number Interface
fun BigNum.toDouble() = this.toString().toDouble()
fun BigNum.toFloat() = this.toString().toFloat()
fun BigNum.toLong() = this.toString().toLong()
fun BigNum.toInt() = this.toString().toInt()
fun BigNum.toShort() = this.toString().toShort()
fun BigNum.toByte() = this.toString().toByte()