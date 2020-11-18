package com.jeanbarrossilva.laura.extension

import android.view.View
import android.view.inputmethod.InputMethodManager.HIDE_IMPLICIT_ONLY
import android.view.inputmethod.InputMethodManager.SHOW_FORCED
import com.jeanbarrossilva.laura.extension.ContextX.inputMethodManager

object ViewX {
    fun View.hideSoftInput() = context.inputMethodManager.hideSoftInputFromWindow(windowToken, HIDE_IMPLICIT_ONLY)

    fun View.showSoftInput() = context.inputMethodManager.showSoftInput(this, SHOW_FORCED)
}