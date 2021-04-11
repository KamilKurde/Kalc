package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

object Multipliers
{
	val kilo = BigDecimal.fromInt(1_000)
	val kilo2 = kilo * kilo
	val kilo3 = kilo2 * kilo
	val deci = BigDecimal.fromFloat(0.1f)
	val deci2 = deci * deci
	val deci3 = deci2 * deci
	val liter = deci3
	val centi = BigDecimal.fromFloat(0.01f)
	val centi2 = centi * centi
	val centi3 = centi2 * centi
	val milli = BigDecimal.fromFloat(0.001f)
	val milli2 = milli * milli
	val nano = BigDecimal.parseString("0.000000001")
	val nano2 = nano * nano
	val pico = BigDecimal.parseString("0.000000000001")
	val pico2 = pico * pico
	val barrel = BigDecimal.parseString("0.158987294928")
}