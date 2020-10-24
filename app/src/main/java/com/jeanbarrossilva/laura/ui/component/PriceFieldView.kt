package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.jeanbarrossilva.laura.R
import kotlinx.android.synthetic.main.view_price_field.view.*
import java.util.*

class PriceFieldView : LinearLayout {
    var currency: Currency = Locale.getDefault().let { defaultLocale ->
        Currency.getInstance(defaultLocale)
    }
        set(value) {
            field = value
            currencyView.text = value.symbol
        }

    constructor(context: Context) : super(context) {
        inflate(context, R.layout.view_price_field, this)
        start()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        inflate(context, R.layout.view_price_field, this)
        start()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        inflate(context, R.layout.view_price_field, this)
        start()
    }

    private fun start() {
        currencyView.text = currency.symbol
    }
}