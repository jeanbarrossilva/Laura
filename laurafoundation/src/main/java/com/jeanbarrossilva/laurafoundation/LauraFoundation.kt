package com.jeanbarrossilva.laurafoundation

import java.text.NumberFormat
import java.util.Currency

object LauraFoundation {
    val currencies = Currency.getAvailableCurrencies().sortedBy { it.currencyCode }

    val doubleDigitFormat: NumberFormat = NumberFormat.getInstance().apply {
        minimumIntegerDigits = 2
        maximumIntegerDigits = 2
    }

    val currencyFormat: NumberFormat = NumberFormat.getInstance().apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
}