package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.core.view.updateLayoutParams
import com.jeanbarrossilva.laura.LauraApplication.Companion.primaryTextColor
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.data.ComponentEditor
import com.jeanbarrossilva.laurafoundation.data.ComponentEditorState.EditingState

class LauraTextView : AppCompatEditText {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setEnabled(enabled: Boolean) {
        val background = if (enabled) ContextCompat.getDrawable(context, R.drawable.bg_laura_text_view) else null
        val spacing = if (enabled) 20 else 0

        super.setEnabled(enabled)

        this.background = background
        setPadding(spacing)
        if (!enabled) setTextColor(primaryTextColor)
        updateLayoutParams<ViewGroup.MarginLayoutParams> { setMargins(spacing) }
    }

    private fun config() {
        layoutParams = ViewGroup.MarginLayoutParams(width, height)
        isEnabled = false
        setAutoSizeTextTypeWithDefaults(AUTO_SIZE_TEXT_TYPE_UNIFORM)
    }

    fun withStateOf(componentEditor: ComponentEditor) = componentEditor.observe({ state() }) { isEnabled = it is EditingState }

    init {
        config()
    }
}