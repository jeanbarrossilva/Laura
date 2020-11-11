package com.jeanbarrossilva.laurafoundation.ext

import android.view.View
import com.jeanbarrossilva.laurafoundation.ext.ContextX.inputMethodManager

object ViewX {
    fun View.hideSoftInput() = context.inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}