package com.jeanbarrossilva.laura.extension

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

object KClassX {
    fun <T : Any> KClass<T>.values(vararg args: Array<out Any?>) =
        sealedSubclasses.mapIndexed { index, kClass -> kClass.objectInstance ?: kClass.primaryConstructor?.call(*args[index]) }
}