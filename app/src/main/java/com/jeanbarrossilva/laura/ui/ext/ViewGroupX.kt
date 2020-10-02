package com.jeanbarrossilva.laura.ui.ext

import android.view.View
import android.view.ViewGroup

object ViewGroupX {
    fun ViewGroup.addIdentifiedView(child: View?) {
        child?.id = View.generateViewId()
        addView(child)
    }
}