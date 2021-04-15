package com.github.KamilKurde.Kalc.units

import com.github.KamilKurde.Kalc.Multipliers
import com.github.KamilKurde.Kalc.functions.parseNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal

enum class MassUnits
{
	Tons,
	Slugs,
	Kilograms,
	Pounds,
	Ounces,
	Decagrams,
	Grams,
	Milligrams,
}

data class MassRange(val start: Mass, val end: Mass)
{
	operator fun contains(mass: Mass) =
		mass >= start && mass <= end
}

// function to use when instantiating Lenght class
fun Mass(
	value: Number,
	unit: MassUnits = MassUnits.Grams
) = Mass(BigDecimal.parseString(value.toString()), unit)

fun Mass(
	value: BigDecimal,
	unit: MassUnits = MassUnits.Grams
) = Mass(
	value * when (unit)
	{
		MassUnits.Tons       -> Multipliers.mega
		MassUnits.Slugs      -> Multipliers.slug
		MassUnits.Kilograms  -> Multipliers.kilo
		MassUnits.Pounds     -> Multipliers.pound
		MassUnits.Ounces     -> Multipliers.ounce
		MassUnits.Decagrams  -> Multipliers.deca
		MassUnits.Milligrams -> Multipliers.milli
		else                 -> BigDecimal.ONE
	}
)

class Mass(
	var inGrams: BigDecimal,
)
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

	override operator fun equals(other: Any?): Boolean
	{
		if (other == null || other !is Mass)
			return false
		return inGrams == other.inGrams
	}

	operator fun compareTo(mass: Mass) =
		inMilligrams.compareTo(mass.inMilligrams)
}

val Number.tones get() = Mass(this, MassUnits.Tons)
val Number.slugs get() = Mass(this, MassUnits.Slugs)
val Number.kilograms get() = Mass(this, MassUnits.Kilograms)
val Number.pounds get() = Mass(this, MassUnits.Pounds)
val Number.ounces get() = Mass(this, MassUnits.Ounces)
val Number.decagrams get() = Mass(this, MassUnits.Decagrams)
val Number.grams get() = Mass(this, MassUnits.Grams)
val Number.milligrams get() = Mass(this, MassUnits.Milligrams)