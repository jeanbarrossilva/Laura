package com.jeanbarrossilva.laura.ext

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.jeanbarrossilva.laura.ext.LinearLayoutX.addViewInvalidating

object ViewGroupX {
    fun ViewGroup.addIdentifiedView(child: View?) {
        child?.id = View.generateViewId()
        addView(child)
    }

    fun ViewGroup.addViews(vararg children: View?, invalidates: Boolean = true) {
        children.forEach { child ->
            if (this is LinearLayout && invalidates) addViewInvalidating(child) else addView(child)
        }
    }
}