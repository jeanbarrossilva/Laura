package com.jeanbarrossilva.lauraui.ext

import android.content.Context
import com.jeanbarrossilva.lauraui.R

object ContextX {
    val Context.primaryColor get() = getColor(R.color.colorPrimary)
}