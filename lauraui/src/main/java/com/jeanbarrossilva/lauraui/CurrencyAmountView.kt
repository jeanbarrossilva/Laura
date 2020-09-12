package com.jeanbarrossilva.lauraui

import android.content.Context
import android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
import android.util.AttributeSet
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.*
import com.jeanbarrossilva.lauraui.ext.NumberX.dp
import java.util.Currency
import java.util.Locale

class CurrencyAmountView : RelativeLayout {
    private lateinit var amountField: EditText
    private lateinit var currencySpinner: Spinner

    var currency: Currency = Locale.getDefault().let { defaultLocale -> Currency.getInstance(defaultLocale) }

    constructor(context: Context) : super(context) {
        start()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        start(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        start(attrs, defStyleAttr)
    }

    fun getAmount() = amountField.text.toString().toFloatOrNull()

    private fun start(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        initValues(attrs, defStyleAttr)
        addView(amountField)
        addView(currencySpinner)
    }

    private fun initValues(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        amountField = EditText(ContextThemeWrapper(context, R.style.LauraEditText), attrs, defStyleAttr).apply {
            inputType = TYPE_NUMBER_FLAG_DECIMAL
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            setPaddingRelative(155.dp, paddingTop, paddingEnd, paddingBottom)
        }

        currencySpinner = Spinner(ContextThemeWrapper(context, R.style.LauraSpinner), attrs, defStyleAttr).apply {
            val codes = Currency.getAvailableCurrencies().map { it.currencyCode }.toTypedArray()
            adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, codes)

            layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                marginStart = 4.5.dp
                addRule(CENTER_VERTICAL)
            }

            onItemSelectedListener = object: AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    currency = Currency.getAvailableCurrencies().elementAt(position)
                    Log.d("CurrencyAmountView", "Selected currency: ${currency.currencyCode}.")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                }
            }
        }
    }
}