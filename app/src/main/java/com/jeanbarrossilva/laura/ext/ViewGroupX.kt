package com.jeanbarrossilva.laura.ext

import android.view.View
import android.view.ViewGroup

object ViewGroupX {
    fun ViewGroup.addIdentifiedView(child: View?) {
        child?.id = View.generateViewId()
        addView(child)
    }
}