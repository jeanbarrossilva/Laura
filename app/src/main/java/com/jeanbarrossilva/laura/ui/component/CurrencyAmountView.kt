package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.PopupMenu
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.LauraFoundation.currencies
import kotlinx.android.synthetic.main.view_currency_amount.view.*
import java.util.Currency
import java.util.Locale

class CurrencyAmountView : LinearLayout {
    var currency: Currency = Locale.getDefault().let { defaultLocale ->
        Currency.getInstance(defaultLocale)
    }
        set(value) {
            field = value
            currencyButton.text = value.symbol
        }

    constructor(context: Context) : super(context) {
        inflate(context, R.layout.view_currency_amount, this)
        start()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        inflate(context, R.layout.view_currency_amount, this)
        start()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        inflate(context, R.layout.view_currency_amount, this)
        start()
    }

    fun getAmount() = amountField.text.toString().toFloatOrNull()

    private fun start() {
        val currenciesPopup = PopupMenu(context, currencyButton)

        for (currency in currencies)
            currenciesPopup.menu.add(currency.currencyCode)

        currenciesPopup.setOnMenuItemClickListener { item ->
            currencies.find { it.currencyCode == item.title }?.let { correspondingCurrency ->
                currency = correspondingCurrency
            }

            true
        }

        currencyButton.setOnClickListener {
            currenciesPopup.show()
        }
    }
}