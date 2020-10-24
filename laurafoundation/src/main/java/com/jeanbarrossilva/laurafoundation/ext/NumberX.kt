package com.jeanbarrossilva.laurafoundation.ext

object NumberX {
    infix fun Number.percentOf(other: Number) = this.toFloat() * (other.toFloat() / 100)
}