package com.jeanbarrossilva.lauradata.extension

import java.util.Currency
import java.util.Locale

object CurrencyX {
    val orderedCurrencies = Currency.getAvailableCurrencies().sortedBy { it.currencyCode }
    
    fun localCurrency(): Currency = Locale.getDefault().let { Currency.getInstance(it) }
}