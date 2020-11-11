package com.jeanbarrossilva.laurafoundation.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object MutableLiveDataX {
    fun <T> MutableLiveData<T>.toLiveData() = this as LiveData<T>
}