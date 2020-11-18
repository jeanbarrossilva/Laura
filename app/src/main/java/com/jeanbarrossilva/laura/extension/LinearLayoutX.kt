package com.jeanbarrossilva.laura.extension

import android.view.View
import android.widget.LinearLayout

object LinearLayoutX {
    fun LinearLayout.addViewInvalidating(child: View?) {
        addView(child)
        invalidate()
    }
}