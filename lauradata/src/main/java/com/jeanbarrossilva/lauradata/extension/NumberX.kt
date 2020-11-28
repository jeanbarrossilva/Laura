package com.jeanbarrossilva.lauradata.extension

import java.text.NumberFormat

object NumberX {
    private val doubleDigitFormat: NumberFormat = NumberFormat.getInstance().apply {
        minimumIntegerDigits = 2
        maximumIntegerDigits = 2
    }

    val currencyFormat: NumberFormat = NumberFormat.getInstance().apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    val Number.withDoubleDigit: String get() = doubleDigitFormat.format(this)

    infix fun Number.percentOf(other: Number) = this.toFloat() * (other.toFloat() / 100)
}