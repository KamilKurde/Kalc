package com.github.KamilKurde.Kalc.functions

import com.ionspin.kotlin.bignum.decimal.BigDecimal

fun BigDecimal.readable() = this.toStringExpanded()