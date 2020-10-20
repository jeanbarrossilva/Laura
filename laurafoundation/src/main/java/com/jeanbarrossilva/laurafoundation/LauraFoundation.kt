package com.jeanbarrossilva.laurafoundation

import java.text.NumberFormat
import java.util.Currency

object LauraFoundation {
    val currencies = Currency.getAvailableCurrencies().sortedBy { it.currencyCode }

    val currencyFormat = NumberFormat.getInstance().apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
}