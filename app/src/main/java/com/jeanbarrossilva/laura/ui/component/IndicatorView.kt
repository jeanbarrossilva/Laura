package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.extension.NumberX.dp
import top.defaults.drawabletoolbox.DrawableBuilder

class IndicatorView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {
    init {
        background = DrawableBuilder().oval().solidColor(context.getColor(R.color.colorPrimary)).build()
        layoutParams = LinearLayout.LayoutParams(7.5.dp, 7.5.dp)
    }
}