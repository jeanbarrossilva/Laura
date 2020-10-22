package com.jeanbarrossilva.laura.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

object LiveDataX {
    fun Collection<LiveData<*>>.observeFrom(owner: LifecycleOwner, block: () -> Unit) = forEach { data ->
        data.observe(owner) {
            block()
        }
    }
}