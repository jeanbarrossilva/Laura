package com.jeanbarrossilva.laura.extension

import android.content.res.Resources
import android.util.TypedValue
import java.text.NumberFormat
import kotlin.math.roundToInt

object NumberX {
    private val doubleDigitFormat: NumberFormat = NumberFormat.getInstance().apply {
        minimumIntegerDigits = 2
        maximumIntegerDigits = 2
    }

    val currencyFormat: NumberFormat = NumberFormat.getInstance().apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    private val dimensionAs = { value: Number, dimension: Int ->
        TypedValue.applyDimension(dimension, value.toFloat(), Resources.getSystem().displayMetrics).roundToInt()
    }

    val Number.dp get() = dimensionAs(this, TypedValue.COMPLEX_UNIT_DIP)
    val Number.withDoubleDigit: String get() = doubleDigitFormat.format(this)

    infix fun Number.percentOf(other: Number) = this.toFloat() * (other.toFloat() / 100)
}