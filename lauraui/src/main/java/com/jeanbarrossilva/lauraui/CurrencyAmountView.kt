package com.jeanbarrossilva.lauraui

import android.content.Context
import android.util.AttributeSet
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class CurrencyAmountView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {
    var currency: Currency = Locale.getDefault().let { defaultLocale -> Currency.getInstance(defaultLocale) }
    var amount: Float? = null

    init {
        inflate(context, R.layout.view_currency_amount, this)

        initValues()
        setupCurrencySpinner()
    }

    private fun initValues() {
        val amountField = findViewById<EditText>(R.id.amount)
        amount = amountField.text.toString().toFloatOrNull()
    }

    private fun setupCurrencySpinner() {
        val spinner = findViewById<Spinner>(R.id.currency)
        val currencyCodes = Currency.getAvailableCurrencies().map { it.currencyCode }.toTypedArray()

        spinner.adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, currencyCodes)
    }
}