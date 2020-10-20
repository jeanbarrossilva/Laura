package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity.CENTER_HORIZONTAL
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.children
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ext.NumberX.dp
import top.defaults.drawabletoolbox.DrawableBuilder

class IndicatorLayout @JvmOverloads constructor(context: Context, private val attrs: AttributeSet? = null, private val defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr) {
    var count: Int = 0

    init {
        config()
        loadAttrs()
        setupIndicators()
        highlightIndicatorAt(0)
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        if (child is IndicatorView) super.addView(child, index, params) else throw IllegalStateException("$child is not an IndicatorView. " +
                "Views added to IndicatorLayout must be inherited from IndicatorView.")
    }

    fun highlightIndicatorAt(highlightedIndex: Int) {
        children.filterIsInstance<IndicatorView>().forEachIndexed { index, indicator ->
            indicator.alpha = if (index == highlightedIndex) 1f else 0.5f
        }
    }

    private fun config() {
        dividerDrawable = DrawableBuilder().width(10.dp).build()
        showDividers = SHOW_DIVIDER_MIDDLE
        gravity = CENTER_HORIZONTAL
    }

    private fun loadAttrs() {
        context.theme.obtainStyledAttributes(attrs, R.styleable.IndicatorLayout, defStyleAttr, 0).run {
            for (index in 0 until indexCount) getIndex(index).let { if (it == R.styleable.IndicatorLayout_count) count = getInteger(it, 0) }
            recycle()
        }
    }

    private fun setupIndicators() {
        for (index in 0 until count) {
            val indicator = IndicatorView(context).apply { alpha = 0.5f }
            addView(indicator)
        }
    }
}