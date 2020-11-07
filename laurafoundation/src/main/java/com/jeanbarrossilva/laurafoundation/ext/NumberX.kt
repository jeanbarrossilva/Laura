package com.jeanbarrossilva.laurafoundation.ext

import com.jeanbarrossilva.laurafoundation.LauraFoundation

object NumberX {
    val Number.withDoubleDigit: String get() = LauraFoundation.doubleDigitFormat.format(this)

    infix fun Number.percentOf(other: Number) = this.toFloat() * (other.toFloat() / 100)
}