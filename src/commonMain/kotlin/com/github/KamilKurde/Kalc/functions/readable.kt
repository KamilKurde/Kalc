package com.github.KamilKurde.Kalc.functions

import com.ionspin.kotlin.bignum.decimal.BigDecimal

inline fun BigDecimal.readable() = this.toStringExpanded()