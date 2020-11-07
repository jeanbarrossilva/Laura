package com.jeanbarrossilva.laurafoundation.ext

object SequenceX {
    fun <T> Sequence<T>.withEach(block: T.() -> Unit) = forEach { block(it) }
}