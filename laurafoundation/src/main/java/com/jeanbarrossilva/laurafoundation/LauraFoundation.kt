package com.jeanbarrossilva.laurafoundation

import java.util.*

object LauraFoundation {
    val currencies = Currency.getAvailableCurrencies().sortedBy { it.currencyCode }

    infix fun currencyFor(locale: Locale) = Currency.getInstance(locale)
}