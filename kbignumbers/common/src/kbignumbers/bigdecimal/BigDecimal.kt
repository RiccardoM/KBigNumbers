package kbignumbers.bigdecimal

import kbignumbers.biginteger.BigInteger

expect class BigDecimal : Number, Comparable<BigDecimal> {

    /**
     * Translates the decimal String representation of a BigDecimal into a BigDecimal.
     */
    constructor(value: String)

    /**
     * Translates a {@code BigInteger} into a {@code BigDecimal}.
     * The scale of the {@code BigDecimal} is zero.
     *
     * @param value {@code BigInteger} value to be converted to
     *              {@code BigDecimal}.
     */
    constructor(value: BigInteger)

    /**
     * Returns a BigDecimal whose value is {@code (this + value)}.
     *
     * @param `value` value to be added to this BigDecimal.
     * @return {@code this + value}
     */
    fun add(value: BigDecimal): BigDecimal

    /**
     * Returns a BigDecimal whose value is {@code (this - val)}.
     *
     * @param value value to be subtracted from this BigDecimal.
     * @return {@code this - val}
     */
    fun subtract(value: BigDecimal): BigDecimal

    /**
     * Returns a BigDecimal whose value is {@code (this * val)}.
     *
     * @param value value to be multiplied by this BigDecimal.
     * @return {@code this * val}
     */
    fun multiply(value: BigDecimal): BigDecimal

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this /
     * divisor)}, and whose preferred scale is {@code (this.scale() -
     * divisor.scale())}; if the exact quotient cannot be
     * represented (because it has a non-terminating decimal
     * expansion) an {@code ArithmeticException} is thrown.
     *
     * @param value value by which this {@code BigDecimal} is to be divided.
     * @throws ArithmeticException if the exact quotient does not have a
     *         terminating decimal expansion
     */
    fun divide(value: BigDecimal): BigDecimal

    /**
     * Returns a BigDecimal whose value is {@code (this % val)}.
     *
     * @param value value by which this BigDecimal is to be divided, and the
     *         remainder computed.
     * @return {@code this % val}
     * @throws ArithmeticException if {@code val} is zero.
     */
    fun remainder(value: BigDecimal): BigDecimal

    /**
     * Returns the signum function of this BigDecimal.
     *
     * @return -1, 0 or 1 as the value of this BigDecimal is negative, zero or
     *         positive.
     */
    fun signum(): Int

    /**
     * Returns the string representation of this {@code BigDecimal},
     * using scientific notation if an exponent is needed.
     *
     * <p>A standard canonical string form of the {@code BigDecimal}
     * is created as though by the following steps: first, the
     * absolute value of the unscaled value of the {@code BigDecimal}
     * is converted to a string in base ten using the characters
     * {@code '0'} through {@code '9'} with no leading zeros (except
     * if its value is zero, in which case a single {@code '0'}
     * character is used).
     *
     * <p>Next, an <i>adjusted exponent</i> is calculated; this is the
     * negated scale, plus the number of characters in the converted
     * unscaled value, less one.  That is,
     * {@code -scale+(ulength-1)}, where {@code ulength} is the
     * length of the absolute value of the unscaled value in decimal
     * digits (its <i>precision</i>).
     *
     * <p>If the scale is greater than or equal to zero and the
     * adjusted exponent is greater than or equal to {@code -6}, the
     * number will be converted to a character form without using
     * exponential notation.  In this case, if the scale is zero then
     * no decimal point is added and if the scale is positive a
     * decimal point will be inserted with the scale specifying the
     * number of characters to the right of the decimal point.
     * {@code '0'} characters are added to the left of the converted
     * unscaled value as necessary.  If no character precedes the
     * decimal point after this insertion then a conventional
     * {@code '0'} character is prefixed.
     *
     * <p>Otherwise (that is, if the scale is negative, or the
     * adjusted exponent is less than {@code -6}), the number will be
     * converted to a character form using exponential notation.  In
     * this case, if the converted {@code BigInteger} has more than
     * one digit a decimal point is inserted after the first digit.
     * An exponent in character form is then suffixed to the converted
     * unscaled value (perhaps with inserted decimal point); this
     * comprises the letter {@code 'E'} followed immediately by the
     * adjusted exponent converted to a character form.  The latter is
     * in base ten, using the characters {@code '0'} through
     * {@code '9'} with no leading zeros, and is always prefixed by a
     * sign character {@code '-'} (<tt>'&#92;u002D'</tt>) if the
     * adjusted exponent is negative, {@code '+'}
     * (<tt>'&#92;u002B'</tt>) otherwise).
     *
     * <p>Finally, the entire string is prefixed by a minus sign
     * character {@code '-'} (<tt>'&#92;u002D'</tt>) if the unscaled
     * value is less than zero.  No sign character is prefixed if the
     * unscaled value is zero or positive.
     *
     * <p><b>Examples:</b>
     * <p>For each representation [<i>unscaled value</i>, <i>scale</i>]
     * on the left, the resulting string is shown on the right.
     * <pre>
     * [123,0]      "123"
     * [-123,0]     "-123"
     * [123,-1]     "1.23E+3"
     * [123,-3]     "1.23E+5"
     * [123,1]      "12.3"
     * [123,5]      "0.00123"
     * [123,10]     "1.23E-8"
     * [-123,12]    "-1.23E-10"
     * </pre>
     *
     * <b>Notes:</b>
     * <ol>
     *
     * <li>There is a one-to-one mapping between the distinguishable
     * {@code BigDecimal} values and the result of this conversion.
     * That is, every distinguishable {@code BigDecimal} value
     * (unscaled value and scale) has a unique string representation
     * as a result of using {@code toString}.  If that string
     * representation is converted back to a {@code BigDecimal} using
     * the {@link #BigDecimal(String)} constructor, then the original
     * value will be recovered.
     *
     * <li>The string produced for a given number is always the same;
     * it is not affected by locale.  This means that it can be used
     * as a canonical string representation for exchanging decimal
     * data, or as a key for a Hashtable, etc.  Locale-sensitive
     * number formatting and parsing is handled by the {@link
     * java.text.NumberFormat} class and its subclasses.
     *
     * <li>The {@link #toEngineeringString} method may be used for
     * presenting numbers with exponents in engineering notation, and the
     * {@link #setScale(int,RoundingMode) setScale} method may be used for
     * rounding a {@code BigDecimal} so it has a known number of digits after
     * the decimal point.
     *
     * <li>The digit-to-character mapping provided by
     * {@code Character.forDigit} is used.
     *
     * </ol>
     *
     * @return string representation of this {@code BigDecimal}.
     */
    override fun toString(): String

    /**
     * Converts this {@code BigDecimal} to a {@code byte}, checking
     * for lost information.  If the value of this {@code BigDecimal}
     * is out of the range of the {@code byte} type, then an
     * {@code ArithmeticException} is thrown.
     *
     * @return this {@code BigDecimal} converted to a {@code byte}.
     * @throws ArithmeticException if the value of {@code this} will
     * not exactly fit in a {@code byte}.
     */
    fun byteValueExact(): Byte

    companion object {
        val ZERO: BigDecimal
        val ONE: BigDecimal
        val TEN: BigDecimal
        fun valueOf(value: Long): BigDecimal
    }
}
