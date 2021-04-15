package com.github.KamilKurde.Kalc

import com.github.KamilKurde.Kalc.functions.readable
import com.ionspin.kotlin.bignum.decimal.BigDecimal

abstract class Kalc
{
	internal fun readableString(component1: BigDecimal) = this::class.simpleName + "(" + component1.readable() + ")"
}