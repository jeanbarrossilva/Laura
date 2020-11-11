package com.jeanbarrossilva.laurafoundation.`interface`

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.jeanbarrossilva.laurafoundation.data.ComponentEditorState
import com.jeanbarrossilva.laurafoundation.data.ComponentEditorState.*
import com.jeanbarrossilva.laurafoundation.ext.MutableLiveDataX.toLiveData

interface ComponentEditor {
    private val state get() = MutableLiveData<ComponentEditorState>(NonEditingState)

    val lifecycleOwner: LifecycleOwner

    fun state() = state.toLiveData()

    fun switchState() {
        state.value = EditingState
        Log.d("ComponentEditor.switchState", "${runCatching { state.value!!::class.simpleName }.getOrNull()}")
    }
}