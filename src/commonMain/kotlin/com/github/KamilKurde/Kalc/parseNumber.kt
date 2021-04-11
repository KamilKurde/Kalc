package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

fun BigDecimal.Companion.parseNumber(number: Number) = BigDecimal.parseString(number.toString())