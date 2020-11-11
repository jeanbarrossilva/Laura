package com.jeanbarrossilva.laurafoundation.ext

import androidx.lifecycle.LiveData
import com.jeanbarrossilva.laurafoundation.`interface`.ComponentEditor

object ComponentEditorX {
    fun <T> ComponentEditor.observe(liveData: ComponentEditor.() -> LiveData<T>, block: (T) -> Unit) =
        liveData(this).observe(lifecycleOwner) { block(it) }
}