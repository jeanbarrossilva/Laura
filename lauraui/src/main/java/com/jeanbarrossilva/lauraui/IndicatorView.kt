package com.jeanbarrossilva.lauraui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.jeanbarrossilva.lauraui.ext.NumberX.dp
import com.jeanbarrossilva.lauraui.ext.ThemeX.primaryColor
import top.defaults.drawabletoolbox.DrawableBuilder

class IndicatorView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {
    init {
        background = DrawableBuilder().oval().solidColor(context.theme.primaryColor).build()
        layoutParams = LinearLayout.LayoutParams(7.5.dp, 7.5.dp)
    }
}