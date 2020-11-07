package com.jeanbarrossilva.laura.ext

import android.view.View
import android.widget.LinearLayout

object LinearLayoutX {
    fun LinearLayout.addViewInvalidating(child: View?) {
        addView(child)
        invalidate()
    }
}