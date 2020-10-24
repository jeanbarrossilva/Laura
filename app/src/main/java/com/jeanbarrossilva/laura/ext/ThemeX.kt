package com.jeanbarrossilva.laura.ext

import android.content.res.Resources.Theme
import android.util.TypedValue
import androidx.annotation.AttrRes

object ThemeX {
    fun Theme.attr(@AttrRes res: Int) = TypedValue().apply typedValue@{ resolveAttribute(res, this@typedValue, true) }
}