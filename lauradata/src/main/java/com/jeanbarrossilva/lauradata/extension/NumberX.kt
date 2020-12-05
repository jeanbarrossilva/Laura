package com.jeanbarrossilva.lauradata.extension

import com.jeanbarrossilva.lauradata.extension.CurrencyX.localCurrency
import java.text.NumberFormat
import java.util.Currency

object NumberX {
    private val doubleDigitFormat: NumberFormat = NumberFormat.getInstance().apply {
        minimumIntegerDigits = 2
        maximumIntegerDigits = 2
    }

    private val currencyFormat: NumberFormat = NumberFormat.getInstance().apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    val Number.withDoubleDigit: String get() = doubleDigitFormat.format(this)

    fun Number.formattedAsCurrency(currency: Currency = localCurrency()) = "${currency.symbol} ${currencyFormat.format(this.toFloat())}"

    infix fun Number.percentOf(other: Number) = this.toFloat() * (other.toFloat() / 100)
}