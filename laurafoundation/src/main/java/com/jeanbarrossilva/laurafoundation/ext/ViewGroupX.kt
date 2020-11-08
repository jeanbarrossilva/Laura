package com.jeanbarrossilva.laurafoundation.ext

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.jeanbarrossilva.laurafoundation.ext.LinearLayoutX.addViewInvalidating

object ViewGroupX {
    fun ViewGroup.addViews(vararg children: View?, invalidates: Boolean = true) {
        children.forEach { child ->
            if (this is LinearLayout && invalidates) addViewInvalidating(child) else addView(child)
        }
    }
}