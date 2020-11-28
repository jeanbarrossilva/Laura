package com.jeanbarrossilva.laura2.viewmodel.factory

import androidx.compose.material.ExperimentalMaterialApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbarrossilva.laura2.activities.MainActivity

@ExperimentalMaterialApi
class MainViewModelFactory(private val activity: MainActivity) : ViewModelProvider.Factory {
	override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(MainActivity::class.java).newInstance(activity)
}