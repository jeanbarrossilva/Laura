package com.jeanbarrossilva.laurafoundation.ext

import android.app.Activity
import android.view.View
import com.jeanbarrossilva.laurafoundation.ext.ViewX.hideSoftInput

object ActivityX {
    fun Activity.hideSoftInput() {
        val view = currentFocus ?: View(this)
        view.hideSoftInput()
    }
}