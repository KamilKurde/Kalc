package com.github.KamilKurde.Kalc

import com.github.KamilKurde.Kalc.functions.parseNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal

object Multipliers
{
	// Standard
	val pico by lazy { BigDecimal.parseString("0.000000000001") }
	val nano by lazy { BigDecimal.parseString("0.000000001") }
	val milli by lazy { BigDecimal.fromFloat(0.001f) }
	val centi by lazy { BigDecimal.fromFloat(0.01f) }
	val deci by lazy { BigDecimal.fromFloat(0.1f) }
	val deca by lazy { BigDecimal.fromInt(10) }
	val kilo by lazy { BigDecimal.fromInt(1_000) }
	val mega by lazy { kilo * kilo }
	val giga by lazy { mega * kilo }
	val tera by lazy { giga * kilo }
	val peta by lazy { tera * kilo }
	val exa by lazy { peta * kilo }
	val zetta by lazy { exa * kilo }
	val yotta by lazy { zetta * kilo }

	// Distance
	val inch by lazy { BigDecimal.parseNumber(25.4) * milli }
	val foot by lazy { inch * 12 }
	val yard by lazy { foot * 3 }
	val mile by lazy { foot * 5280 }

	// Area
	val inch2 by lazy { BigDecimal.parseString("0.00064516") }
	val foot2 by lazy { inch2 * 144 }
	val yard2 by lazy { foot2 * 9 }
	val mile2 by lazy { yard2 * 3_097_600 }
	val kilo2 by lazy { kilo * kilo }
	val deci2 by lazy { deci * deci }
	val centi2 by lazy { centi * centi }
	val milli2 by lazy { milli * milli }
	val nano2 by lazy { nano * nano }
	val pico2 by lazy { pico * pico }

	// Volume
	val kilo3 by lazy { kilo2 * kilo }
	val barrel by lazy { BigDecimal.parseString("0.158987294928") }
	val deci3 by lazy { deci2 * deci }
	val liter by lazy { deci3 }
	val centi3 by lazy { centi2 * centi }
	val megalitre by lazy { liter * mega }

	// Time
	val minute by lazy { BigDecimal.fromInt(60) }
	val hour by lazy { BigDecimal.fromInt(60) * minute }
	val day by lazy { hour * 24 }
	val week by lazy { day * 7 }
	val year by lazy { day * 365 }

	// Speed
	val knot by lazy { BigDecimal.parseString("0.514444") }
	val mph by lazy { BigDecimal.parseString("0.44704") }
	val fps by lazy { BigDecimal.parseString("0.3048") }
	val kmph by lazy { BigDecimal.parseNumber(1 / 3.6) }

	// Mass
	val ounce by lazy { BigDecimal.parseString("28.3495231") }
	val pound by lazy { ounce * 16 }
	val slug by lazy { BigDecimal.parseString("14.5939029") * kilo }

	// Data
	val bit by lazy { BigDecimal.ONE / BigDecimal.parseNumber(8) }
	val kibi by lazy { BigDecimal.parseNumber(1024) }
	val mebi by lazy { kibi * kibi }
	val gibi by lazy { mebi * kibi }
	val tebi by lazy { gibi * kibi }
	val pebi by lazy { tebi * kibi }
	val exbi by lazy { pebi * kibi }
	val zebi by lazy { exbi * kibi }
	val yobi by lazy { zebi * kibi }
}