package com.jeanbarrossilva.laura.ext

import android.content.res.Resources
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import kotlin.math.roundToInt

object NumberX {
    private val dimensionAs = { value: Number, dimension: Int ->
        TypedValue.applyDimension(dimension, value.toFloat(), Resources.getSystem().displayMetrics).roundToInt()
    }

    val Number.dp get() = dimensionAs(this, COMPLEX_UNIT_DIP)
}