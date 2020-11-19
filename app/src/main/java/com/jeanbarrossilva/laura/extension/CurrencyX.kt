package com.jeanbarrossilva.laura.extension

import java.util.Currency

object CurrencyX {
    val orderedCurrencies = Currency.getAvailableCurrencies().sortedBy { it.currencyCode }
}