package com.kamilKurde.kalc.functions

import com.ionspin.kotlin.bignum.decimal.BigDecimal

fun BigDecimal.readable() = this.toStringExpanded()