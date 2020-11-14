package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.jeanbarrossilva.laura.R

class BalanceInfluenceIconView : AppCompatImageView {
    constructor(context: Context) : super(context) {
        config()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        config()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        config()
    }

    private fun config() {
        contentDescription = context.getString(R.string.BalanceInfluence_content_description_icon)
        scaleType = ScaleType.CENTER_INSIDE
        setBackgroundResource(R.drawable.bg_balance_influence_icon)
    }
}