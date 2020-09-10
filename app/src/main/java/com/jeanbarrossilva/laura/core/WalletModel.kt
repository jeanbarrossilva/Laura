package com.jeanbarrossilva.laura.core

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.icu.util.Currency
import android.icu.util.CurrencyAmount
import com.jeanbarrossilva.laura.BillApp.Companion.app

class WalletModel(context: Context?) {
    private val preferences = context?.getSharedPreferences("wallet", MODE_PRIVATE)
    private val currency = app.currencies.find { it.currencyCode == preferences?.getString("currency", "") } ?: Currency.getInstance("BRL")
    private val salary = preferences?.getFloat("salary_value", 0f) ?: 0f

    val balance = CurrencyAmount(salary, currency)
}