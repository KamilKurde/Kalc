package com.github.KamilKurde.Kalc

import com.ionspin.kotlin.bignum.decimal.BigDecimal

object Multipliers
{
	// Standard
	val mega = BigDecimal.fromInt(1_000_000)
	val kilo = BigDecimal.fromInt(1_000)
	val deci = BigDecimal.fromFloat(0.1f)
	val centi = BigDecimal.fromFloat(0.01f)
	val milli = BigDecimal.fromFloat(0.001f)
	val nano = BigDecimal.parseString("0.000000001")
	val pico = BigDecimal.parseString("0.000000000001")

	// Distance
	val inch = BigDecimal.parseNumber(25.4) * milli
	val foot = inch * 12
	val yard = foot * 3
	val mile = foot * 5280

	// Area
	val inch2 = BigDecimal.parseString("0.00064516")
	val foot2 = inch2 * 144
	val yard2 = foot2 * 9
	val mile2 = yard2 * 3_097_600
	val kilo2 = kilo * kilo
	val deci2 = deci * deci
	val centi2 = centi * centi
	val milli2 = milli * milli
	val nano2 = nano * nano
	val pico2 = pico * pico

	// Volume
	val kilo3 = kilo2 * kilo
	val barrel = BigDecimal.parseString("0.158987294928")
	val deci3 = deci2 * deci
	val liter = deci3
	val megaliter = liter * mega

	// Time
	val minute = BigDecimal.fromInt(60)
	val hour = BigDecimal.fromInt(60) * minute
	val day = hour * 24
	val week = day * 7
	val year = day * 365

	// Speed
	val knot = BigDecimal.parseString("0.514444")
	val mph = BigDecimal.parseString("0.44704")
	val fps = BigDecimal.parseString("0.3048")
	val kmph = BigDecimal.parseNumber(1 / 3.6)
}