package com.kamilKurde.kalc

import com.soywiz.kbignum.BigNum
import com.soywiz.kbignum.bn

object Multipliers
{
	// Standard
	val pico by lazy { "0.000000000001".bn }
	val nano by lazy { "0.000000001".bn }
	val milli by lazy { 0.001.bn }
	val centi by lazy { 0.01.bn }
	val deci by lazy { 0.1.bn }
	val deca by lazy { 10.bn }
	val kilo by lazy { 1_000.bn }
	val mega by lazy { kilo * kilo }
	val giga by lazy { mega * kilo }
	val tera by lazy { giga * kilo }
	val peta by lazy { tera * kilo }
	val exa by lazy { peta * kilo }
	val zetta by lazy { exa * kilo }
	val yotta by lazy { zetta * kilo }

	// Distance
	val inch by lazy { "25.4".bn * milli }
	val foot by lazy { inch * 12.bn }
	val yard by lazy { foot * 3.bn }
	val mile by lazy { foot * 5280.bn }

	// Area
	val inch2 by lazy { "0.00064516".bn }
	val foot2 by lazy { inch2 * 144.bn }
	val yard2 by lazy { foot2 * 9.bn }
	val mile2 by lazy { yard2 * 3_097_600.bn }
	val kilo2 by lazy { kilo * kilo }
	val deci2 by lazy { deci * deci }
	val centi2 by lazy { centi * centi }
	val milli2 by lazy { milli * milli }
	val nano2 by lazy { nano * nano }
	val pico2 by lazy { pico * pico }

	// Volume
	val kilo3 by lazy { kilo2 * kilo }
	val barrel by lazy { "0.158987294928".bn }
	val deci3 by lazy { deci2 * deci }
	val liter by lazy { deci3 }
	val centi3 by lazy { centi2 * centi }
	val megalitre by lazy { liter * mega }

	// Time
	val minute by lazy { 60.bn }
	val hour by lazy { 60.bn * minute }
	val day by lazy { hour * 24.bn }
	val week by lazy { day * 7.bn }
	val year by lazy { day * 365.bn }

	// Speed
	val knot by lazy { "0.514444".bn }
	val mph by lazy { "0.44704".bn }
	val fps by lazy { "0.3048".bn }
	val kmph by lazy { 1.bn / 3.6.bn }

	// Mass
	val ounce by lazy { "28.3495231".bn }
	val pound by lazy { ounce * 16.bn }
	val slug by lazy { "14.5939029".bn * kilo }

	// Data
	val bit by lazy { BigNum.ONE / 8.bn }
	val kibi by lazy { 1024.bn }
	val mebi by lazy { kibi * kibi }
	val gibi by lazy { mebi * kibi }
	val tebi by lazy { gibi * kibi }
	val pebi by lazy { tebi * kibi }
	val exbi by lazy { pebi * kibi }
	val zebi by lazy { exbi * kibi }
	val yobi by lazy { zebi * kibi }
}