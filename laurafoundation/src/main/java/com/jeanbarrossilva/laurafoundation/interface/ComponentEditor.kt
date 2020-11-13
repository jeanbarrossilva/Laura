package com.jeanbarrossilva.laurafoundation.`interface`

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.jeanbarrossilva.laurafoundation.data.ComponentEditorState
import com.jeanbarrossilva.laurafoundation.data.ComponentEditorState.*
import com.jeanbarrossilva.laurafoundation.ext.MutableLiveDataX.toLiveData

class ComponentEditor(val lifecycleOwner: LifecycleOwner) {
    private val state get() = MutableLiveData<ComponentEditorState>(NonEditingState)

    fun state() = state.toLiveData()

    fun changeState() {
        state.value = if (state.value is NonEditingState) EditingState else NonEditingState
        Log.d("ComponentEditor.switchState", "${runCatching { state.value!!::class.simpleName }.getOrNull()}")
    }
}