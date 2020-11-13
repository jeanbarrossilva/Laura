package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.graphics.Typeface.BOLD
import android.util.AttributeSet
import android.view.Gravity.END
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM
import androidx.core.view.updatePaddingRelative
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.data.LauraTableCellConfig
import com.jeanbarrossilva.laurafoundation.data.LauraTableCellRepresentationConfig
import com.jeanbarrossilva.laurafoundation.ext.ContextX.obtainStyledAttrs
import com.jeanbarrossilva.laurafoundation.ext.NumberX.dp
import com.jeanbarrossilva.laurafoundation.ext.ViewGroupX.addViews

class LauraTableCellView : LinearLayout {
    private var titleView: TextView? = null
    private var representationView: TextView? = null

    var title: String = ""
        set(value) {
            field = value
            titleView?.text = value
        }

    var representation = LauraTableCellRepresentationConfig(title = "")
        set(value) {
            field = value
            representationView?.text = value.title
            representationView?.inputType = value.fieldInputType
        }

    internal constructor(context: Context) : super(context) {
        start()
    }

    internal constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        start(attrs)
    }

    internal constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        start(attrs, defStyleAttr)
    }

    private fun start(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        config()
        loadAttrs(attrs, defStyleAttr)
        initViews(attrs, defStyleAttr)
        addViews(titleView, representationView)
    }

    private fun config() {
        updatePaddingRelative(bottom = 5.dp)
    }

    private fun loadAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        context.obtainStyledAttrs(R.styleable.BalanceInfluenceTableCellView, attrs, defStyleAttr) {
            when (it) {
                R.styleable.BalanceInfluenceTableCellView_title -> title = getString(it).toString()
                R.styleable.BalanceInfluenceTableCellView_representation -> representation.title = getString(it).toString()
            }
        }
    }

    private fun initViews(attrs: AttributeSet?, defStyleAttr: Int) {
        titleView = TextView(context, attrs, defStyleAttr).apply {
            alpha = 0.7f
            text = title
            textSize = 17f
            configAppearanceOf(this)
        }

        representationView = TextView(context, attrs, defStyleAttr).apply {
            gravity = END
            text = representation.title
            inputType = representation.fieldInputType
            textAlignment = TEXT_ALIGNMENT_VIEW_END
            textSize = 20f
            setTypeface(typeface, BOLD)
            configAppearanceOf(this)
        }
    }

    private fun configAppearanceOf(view: TextView) {
        view.apply {
            maxLines = 1
            layoutParams = LayoutParams(0, WRAP_CONTENT).apply { weight = 0.5f }
            setAutoSizeTextTypeWithDefaults(AUTO_SIZE_TEXT_TYPE_UNIFORM)
        }
    }

    fun configWith(config: LauraTableCellConfig) {
        title = context.getString(config.title)
        representation = config.representationConfig
    }

    init {
        weightSum = 1f
    }
}