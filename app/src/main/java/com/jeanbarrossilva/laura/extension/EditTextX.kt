package com.jeanbarrossilva.laura.extension

import android.widget.EditText
import com.jeanbarrossilva.laura.extension.ViewX.showSoftInput

object EditTextX {
    fun EditText.focusWithInput() {
        requestFocus()
        showSoftInput()
        setSelection(text.length)
    }
}