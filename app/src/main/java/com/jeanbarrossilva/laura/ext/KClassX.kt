package com.jeanbarrossilva.laura.ext

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

object KClassX {
    fun <T : Any> KClass<T>.values(vararg args: Any?) = sealedSubclasses.map { it.objectInstance ?: it.primaryConstructor?.call(args) }
}