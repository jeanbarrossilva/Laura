package com.jeanbarrossilva.laurafoundation.data

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jeanbarrossilva.laurafoundation.data.ComponentEditorState.*
import com.jeanbarrossilva.laurafoundation.ext.MutableLiveDataX.toLiveData

class ComponentEditor(private val lifecycleOwner: LifecycleOwner) {
    private val state = MutableLiveData<ComponentEditorState>(NonEditingState)

    fun state() = state.toLiveData()

    fun <T> observe(liveData: ComponentEditor.() -> LiveData<T>, block: (T?) -> Unit) = liveData(this).observe(lifecycleOwner) { block(it) }

    fun changeState() {
        state.value = if (state.value is NonEditingState) EditingState else NonEditingState
        Log.d("ComponentEditor.switchState", "${runCatching { state.value!!::class.simpleName }.getOrNull()}")
    }
}