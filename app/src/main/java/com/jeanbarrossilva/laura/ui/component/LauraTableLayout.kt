package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import androidx.core.view.children
import com.jeanbarrossilva.laurafoundation.data.LauraTableCellConfig
import com.jeanbarrossilva.laurafoundation.ext.LinearLayoutX.addViewInvalidating

open class LauraTableLayout : LinearLayout {
    val cells = children.map { it as LauraTableCellView }

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

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        when (child) {
            is LauraTableCellView? -> super.addView(child, index, params)
            else -> throw IllegalStateException("BalanceInfluenceTableLayout should only have " +
                    "LauraTableCellView children.")
        }
    }

    private fun start(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        config()
        addCells(attrs, defStyleAttr)
    }

    private fun config() {
        orientation = VERTICAL
    }

    private fun addCells(attrs: AttributeSet?, defStyleAttr: Int) {
        getConfigs().forEach {
            LauraTableCellView(context, attrs, defStyleAttr)
                .apply {
                    layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
                    configWith(it)
                }
                .let { addViewInvalidating(it) }
        }
    }

    open fun getConfigs() = listOf<LauraTableCellConfig>()
}