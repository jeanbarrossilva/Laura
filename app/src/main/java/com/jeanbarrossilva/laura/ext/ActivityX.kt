package com.jeanbarrossilva.laura.ext

import android.app.Activity
import android.view.View
import com.jeanbarrossilva.laura.ext.ContextX.inputMethodManager

object ActivityX {
    fun Activity.hideSoftInput() {
        val view = currentFocus ?: View(this)
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}