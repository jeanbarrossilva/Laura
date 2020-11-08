package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.graphics.Typeface.BOLD
import android.util.AttributeSet
import android.view.Gravity.END
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StringRes
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.ext.ContextX.obtainStyledAttrs
import com.jeanbarrossilva.laurafoundation.ext.ViewGroupX.addViews

class BalanceInfluenceTableCellView : LinearLayout {
    private var titleView: TextView? = null
    private var representationView: TextView? = null

    var title: String = ""
        set(value) {
            field = value
            titleView?.text = value
        }

    var representation: String = ""
        set(value) {
            field = value
            representationView?.text = value
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
        loadAttrs(attrs, defStyleAttr)
        initViews(attrs, defStyleAttr)
        addViews(titleView, representationView)
    }

    private fun loadAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        context.obtainStyledAttrs(R.styleable.BalanceInfluenceTableCellView, attrs, defStyleAttr) {
            when (it) {
                R.styleable.BalanceInfluenceTableCellView_title -> title = getString(it).toString()
                R.styleable.BalanceInfluenceTableCellView_representation ->
                    representation = getString(it).toString()
            }
        }
    }

    private fun initViews(attrs: AttributeSet?, defStyleAttr: Int) {
        val params = LayoutParams(0, WRAP_CONTENT).apply { weight = 0.5f }

        titleView = TextView(context, attrs, defStyleAttr).apply {
            alpha = 0.7f
            text = title
            textSize = 17f
            layoutParams = params
        }

        representationView = TextView(context, attrs, defStyleAttr).apply {
            gravity = END
            textAlignment = TEXT_ALIGNMENT_VIEW_END
            text = representation
            textSize = 20f
            layoutParams = params
            setTypeface(typeface, BOLD)
        }
    }

    fun setTitle(@StringRes titleRes: Int) {
        title = context.getString(titleRes)
    }

    init {
        weightSum = 1f
    }
}