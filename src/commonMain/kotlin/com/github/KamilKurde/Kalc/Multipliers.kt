package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.decimal.DecimalMode

object Multipliers
{
	// Standard
	val kilo = BigDecimal.fromInt(1_000)
	val deci = BigDecimal.fromFloat(0.1f)
	val centi = BigDecimal.fromFloat(0.01f)
	val milli = BigDecimal.fromFloat(0.001f)
	val nano = BigDecimal.parseString("0.000000001")
	val pico = BigDecimal.parseString("0.000000000001")

	// Area
	val kilo2 = kilo * kilo
	val deci2 = deci * deci
	val centi2 = centi * centi
	val milli2 = milli * milli
	val nano2 = nano * nano
	val pico2 = pico * pico

	// Volume
	val kilo3 = kilo2 * kilo
	val deci3 = deci2 * deci
	val liter = deci3
	val centi3 = centi2 * centi
	val barrel = BigDecimal.parseString("0.158987294928")

	// Time
	val minute = BigDecimal.fromInt(60)
	val hour = BigDecimal.fromInt(60) * minute

	// Speed
	val knot = BigDecimal.parseString("0.514444")
	val mph = BigDecimal.parseString("0.44704")
	val fps = BigDecimal.parseString("0.3048")
	val kmph = BigDecimal.parseNumber(1 / 3.6)
}