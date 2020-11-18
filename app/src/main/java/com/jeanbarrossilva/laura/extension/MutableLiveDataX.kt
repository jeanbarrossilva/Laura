package com.jeanbarrossilva.laura.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object MutableLiveDataX {
    fun <T> MutableLiveData<T>.toLiveData() = this as LiveData<T>
}