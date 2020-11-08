package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.view.ContextThemeWrapper
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButton.ICON_GRAVITY_END
import com.jeanbarrossilva.laura.LauraApplication.Companion.tertiaryTextColor
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.ext.NumberX.dp

class CurrencyAmountView : PriceFieldView {
    constructor(context: Context) : super(context) {
        initViews()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initViews(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        initViews(attrs, defStyleAttr)
    }

    private fun initViews(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        currencyView = MaterialButton(
            ContextThemeWrapper(context, R.style.Widget_MaterialComponents_Button_OutlinedButton),
            attrs,
            defStyleAttr
        ).apply {
            translationZ = 1.dp.toFloat()
            iconGravity = ICON_GRAVITY_END
            cornerRadius = 15.dp
            setIconResource(R.drawable.ic_keyboard_arrow_down)
            setIconTintResource(tertiaryTextColor)
        }
    }
}