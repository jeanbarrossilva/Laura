package com.jeanbarrossilva.laura.extension

import android.app.Activity
import android.view.View
import com.jeanbarrossilva.laura.extension.ViewX.hideSoftInput
import com.jeanbarrossilva.laura.extension.ViewX.showSoftInput

object ActivityX {
    private fun Activity.getCurrentFocusOrCreate() = currentFocus ?: View(this)

    fun Activity.hideSoftInput() = getCurrentFocusOrCreate().hideSoftInput()

    fun Activity.showSoftInput() = getCurrentFocusOrCreate().showSoftInput()
}