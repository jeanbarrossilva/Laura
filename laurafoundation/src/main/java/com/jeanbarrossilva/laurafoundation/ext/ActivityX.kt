package com.jeanbarrossilva.laurafoundation.ext

import android.app.Activity
import android.view.View
import com.jeanbarrossilva.laurafoundation.ext.ActivityX.hideSoftInput
import com.jeanbarrossilva.laurafoundation.ext.ViewX.hideSoftInput
import com.jeanbarrossilva.laurafoundation.ext.ViewX.showSoftInput

object ActivityX {
    private fun Activity.getCurrentFocusOrCreate() = currentFocus ?: View(this)

    fun Activity.hideSoftInput() = getCurrentFocusOrCreate().hideSoftInput()

    fun Activity.showSoftInput() = getCurrentFocusOrCreate().showSoftInput()
}