package com.jeanbarrossilva.laura.ext

import com.google.android.material.textfield.TextInputEditText

object TextInputEditTextX {
    fun List<TextInputEditText>.onEmpty(errorMessage: (TextInputEditText) -> String) {
        forEach { field ->
            field.text?.ifEmpty {
                field.error = errorMessage(field)
            }
        }

        return
    }
}