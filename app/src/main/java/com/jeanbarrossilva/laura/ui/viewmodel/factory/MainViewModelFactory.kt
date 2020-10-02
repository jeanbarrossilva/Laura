package com.jeanbarrossilva.laura.ui.viewmodel.factory

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val activity: AppCompatActivity, @IdRes private val containerId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(AppCompatActivity::class.java, Int::class.java).newInstance(activity, containerId)
}