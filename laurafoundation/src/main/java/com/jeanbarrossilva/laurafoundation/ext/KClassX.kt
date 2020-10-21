package com.jeanbarrossilva.laurafoundation.ext

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

object KClassX {
    fun <T : Any> KClass<T>.instantiate(vararg args: Any?) = objectInstance ?: primaryConstructor?.call(args)
}