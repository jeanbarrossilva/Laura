package com.jeanbarrossilva.laura.ui

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue.COMPLEX_UNIT_SP
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ext.NumberX.dp

class PresentationLayout : LinearLayout {
    private val View.isOriginal get() = this == titleView || this == childrenLayout

    private lateinit var titleView: TextView
    private lateinit var childrenLayout: LinearLayout

    var title: String? = null

    constructor(context: Context) : super(context) {
        start()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        start(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        start(attrs, defStyleAttr)
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) =
        if (child?.isOriginal == true) super.addView(child, index, params) else childrenLayout.addView(child, index, params)

    private fun start(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        config()
        loadAttrs(attrs, defStyleAttr)
        initValues(attrs, defStyleAttr)
        addView(titleView)
        addView(childrenLayout)
    }

    private fun config() {
        orientation = VERTICAL
    }

    private fun loadAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        context.theme.obtainStyledAttributes(attrs, R.styleable.PresentationLayout, defStyleAttr, 0).run {
            for (index in 0 until indexCount)
                getIndex(index).let { attr ->
                    when (attr) {
                        R.styleable.PresentationLayout_android_title -> title = getString(attr)
                    }
                }

            recycle()
        }
    }

    private fun initValues(attrs: AttributeSet?, defStyleAttr: Int) {
        titleView = TextView(context, attrs, defStyleAttr).apply {
            alpha = 0.5f
            typeface = resources.getFont(R.font.asap_condensed)
            isAllCaps = true
            title?.let { text = it }
            setPadding(30.dp)
            setTextSize(COMPLEX_UNIT_SP, 50f)
        }

        childrenLayout = LinearLayout(context, attrs, defStyleAttr).apply {
            layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { setMargins(0, 30.dp, 0, 0) }
            setPadding(20.dp, 0, 20.dp, 0)
        }
    }
}