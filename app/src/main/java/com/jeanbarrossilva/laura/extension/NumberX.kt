package com.jeanbarrossilva.laura.extension

import android.content.res.Resources
import android.util.TypedValue
import com.jeanbarrossilva.laurafoundation.LauraFoundation
import kotlin.math.roundToInt

object NumberX {
    private val dimensionAs = { value: Number, dimension: Int ->
        TypedValue.applyDimension(dimension, value.toFloat(), Resources.getSystem().displayMetrics).roundToInt()
    }

    val Number.dp get() = dimensionAs(this, TypedValue.COMPLEX_UNIT_DIP)
    val Number.withDoubleDigit: String get() = LauraFoundation.doubleDigitFormat.format(this)

    infix fun Number.percentOf(other: Number) = this.toFloat() * (other.toFloat() / 100)
}