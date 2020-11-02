package com.jeanbarrossilva.laura.ext

import android.content.Context
import android.util.TypedValue
import android.view.inputmethod.InputMethodManager
import com.jeanbarrossilva.laura.R

object ContextX {
    internal val Context.inputMethodManager get() = getSystemService(InputMethodManager::class.java)

    val Context.colorAttr get() = { attr: Int ->
        TypedValue().apply { theme.resolveAttribute(attr, this, true) }.resourceId.let { color -> getColor(color) }
    }

    val Context.primaryColor get() = getColor(R.color.colorPrimary)
}