package com.jeanbarrossilva.laura.ext

import com.google.android.material.textfield.TextInputEditText

object TextInputEditTextX {
    fun TextInputEditText.required(errorMessage: (TextInputEditText) -> String) {
        text?.ifEmpty {
            error = errorMessage(this)
            return
        }
    }
}