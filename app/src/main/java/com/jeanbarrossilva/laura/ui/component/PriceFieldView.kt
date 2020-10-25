package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity.CENTER
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.afollestad.materialdialogs.utils.MDUtil.maybeSetTextColor
import com.jeanbarrossilva.laura.R
import kotlinx.android.synthetic.main.view_price_field.view.currencyLayout
import java.util.Currency
import java.util.Locale

open class PriceFieldView : LinearLayout {
    internal var currencyView: TextView? = null
        set(value) {
            field = value

            value?.apply {
                gravity = CENTER
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                text = currency.symbol
                layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                maybeSetTextColor(context, android.R.attr.textColorPrimary)
            }
        }

    var currency: Currency = Locale.getDefault().let { defaultLocale ->
        Currency.getInstance(defaultLocale)
    }

    constructor(context: Context) : super(context) {
        start()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        start(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        start(attrs, defStyleAttr)
    }

    private fun start(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        inflate(context, R.layout.view_price_field, this)
        initViews(attrs, defStyleAttr)
        currencyLayout.addView(currencyView)
    }

    private fun initViews(attrs: AttributeSet?, defStyleAttr: Int) {
        currencyView = TextView(context, attrs, defStyleAttr).apply { textSize = 20f }
    }
}