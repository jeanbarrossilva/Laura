package com.jeanbarrossilva.laurafoundation.ext

import android.widget.EditText
import com.jeanbarrossilva.laurafoundation.ext.ViewX.showSoftInput

object EditTextX {
    fun EditText.focusWithInput() {
        requestFocus()
        showSoftInput()
        setSelection(text.length)
    }
}