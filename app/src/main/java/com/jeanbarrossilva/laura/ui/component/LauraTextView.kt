package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.core.view.updateLayoutParams
import com.jeanbarrossilva.laura.LauraApplication.Companion.primaryTextColor
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.`interface`.ComponentEditor
import com.jeanbarrossilva.laurafoundation.data.ComponentEditorState.EditingState
import com.jeanbarrossilva.laurafoundation.ext.ComponentEditorX.observe

class LauraTextView : AppCompatEditText {
    var componentEditor: ComponentEditor? = null
        set(value) {
            field = value
            value?.observe({ state() }) { isEnabled = it is EditingState }
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setEnabled(enabled: Boolean) {
        if (!enabled)
            super.setEnabled(enabled)

        animate()
            .withEndAction {
                val background = if (enabled) ContextCompat.getDrawable(context, R.drawable.bg_laura_text_view) else null
                val spacing = if (enabled) 20 else 0

                if (!enabled)
                    setTextColor(primaryTextColor)

                this.background = background
                setPadding(spacing)
                updateLayoutParams<ViewGroup.MarginLayoutParams> { setMargins(spacing) }
            }
            .start()

        Log.d("LauraTextView.isEnabled", "$isEnabled")
    }

    private fun config() {
        isEnabled = false
        layoutParams = ViewGroup.MarginLayoutParams(width, height)
        setAutoSizeTextTypeWithDefaults(AUTO_SIZE_TEXT_TYPE_UNIFORM)
    }

    init {
        config()
    }
}