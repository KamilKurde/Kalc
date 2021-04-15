package com.github.KamilKurde.Kalc.units.mass

import com.github.KamilKurde.Kalc.Kalc
import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class Mass(
	var inGrams: BigDecimal,
): Kalc()
{
	var inTones: BigDecimal
		get() = inGrams / Multipliers.mega
		set(value)
		{
			inGrams = value * Multipliers.mega
		}
	var inSlugs: BigDecimal
		get() = inGrams / Multipliers.slug
		set(value)
		{
			inGrams = value * Multipliers.slug
		}
	var inYards: BigDecimal
		get() = inGrams / Multipliers.yard
		set(value)
		{
			inGrams = value * Multipliers.yard
		}
	var inKilograms: BigDecimal
		get() = inGrams / Multipliers.kilo
		set(value)
		{
			inGrams = value * Multipliers.kilo
		}
	var inPounds: BigDecimal
		get() = inGrams / Multipliers.pound
		set(value)
		{
			inGrams = value * Multipliers.pound
		}
	var inOunces: BigDecimal
		get() = inGrams / Multipliers.ounce
		set(value)
		{
			inGrams = value * Multipliers.ounce
		}
	var inDecagrams: BigDecimal
		get() = inGrams / Multipliers.deca
		set(value)
		{
			inGrams = value * Multipliers.deca
		}
	var inMilligrams: BigDecimal
		get() = inGrams / Multipliers.milli
		set(value)
		{
			inGrams = value * Multipliers.milli
		}

	operator fun unaryMinus() =
		Mass(-inGrams)

	operator fun plus(mass: Mass) =
		Mass(inGrams + mass.inGrams)

	operator fun minus(mass: Mass) =
		Mass(inGrams - mass.inGrams)

	operator fun times(number: Number) =
		Mass(BigDecimal.parseNumber(number) * inGrams)

	operator fun div(mass: Mass) =
		inGrams / mass.inGrams

	operator fun div(number: Number) =
		Mass(inGrams / BigDecimal.parseNumber(number))

	operator fun rem(mass: Mass) =
		inGrams % mass.inGrams

	operator fun rem(number: Number) =
		Mass(inGrams % BigDecimal.parseNumber(number))

	operator fun rangeTo(mass: Mass) =
		MassRange(this, mass)

	operator fun plusAssign(mass: Mass)
	{
		inGrams += mass.inGrams
	}

	operator fun minusAssign(mass: Mass)
	{
		inGrams -= mass.inGrams
	}

	operator fun timesAssign(number: Number)
	{
		inGrams *= BigDecimal.parseNumber(number)
	}

	operator fun divAssign(number: Number)
	{
		inGrams /= BigDecimal.parseNumber(number)
	}

	operator fun remAssign(number: Number)
	{
		inGrams %= BigDecimal.parseNumber(number)
	}

	operator fun compareTo(mass: Mass) =
		inMilligrams.compareTo(mass.inMilligrams)

	override fun toString() = readableString(component1())
}