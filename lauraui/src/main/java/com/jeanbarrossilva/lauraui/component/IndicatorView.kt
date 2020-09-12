package com.jeanbarrossilva.lauraui.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.jeanbarrossilva.lauraui.ext.ContextX.primaryColor
import com.jeanbarrossilva.lauraui.ext.NumberX.dp
import top.defaults.drawabletoolbox.DrawableBuilder

class IndicatorView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {
    init {
        background = DrawableBuilder().oval().solidColor(context.primaryColor).build()
        layoutParams = LinearLayout.LayoutParams(7.5.dp, 7.5.dp)
    }
}