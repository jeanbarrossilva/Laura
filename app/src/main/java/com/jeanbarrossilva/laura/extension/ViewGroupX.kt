package com.jeanbarrossilva.laura.extension

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.jeanbarrossilva.laura.extension.LinearLayoutX.addViewInvalidating

object ViewGroupX {
    fun ViewGroup.addViews(vararg children: View?, invalidates: Boolean = true) {
        children.forEach { child ->
            if (this is LinearLayout && invalidates) addViewInvalidating(child) else addView(child)
        }
    }
}