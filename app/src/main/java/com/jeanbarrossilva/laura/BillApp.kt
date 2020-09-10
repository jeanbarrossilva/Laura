package com.jeanbarrossilva.laura

import android.app.Application
import android.icu.util.Currency
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class BillApp : Application() {
    val currencies = Currency.getAvailableCurrencies().sortedBy { it.currencyCode }
    val decimalFormat: NumberFormat = DecimalFormat.getInstance()
    val localCurrency: Currency = Locale.getDefault().let { defaultLocale -> Currency.getInstance(defaultLocale) }

    companion object {
        val app = BillApp()
    }
}