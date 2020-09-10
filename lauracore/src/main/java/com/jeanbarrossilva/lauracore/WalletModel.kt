package com.jeanbarrossilva.lauracore

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.icu.util.Currency
import android.icu.util.CurrencyAmount

class WalletModel(context: Context?) {
    private val preferences = context?.getSharedPreferences("wallet", MODE_PRIVATE)
    private val currency = Currency.getAvailableCurrencies().find { it.currencyCode == preferences?.getString("currency", "USD") }
    private val salary = preferences?.getFloat("salary_value", 0f) ?: 0f

    val balance = CurrencyAmount(salary, currency)
}