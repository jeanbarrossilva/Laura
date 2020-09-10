package com.jeanbarrossilva.laura.main

import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val activity: MainActivity, @IdRes private val containerId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(MainActivity::class.java, Int::class.java).newInstance(activity, containerId)
}