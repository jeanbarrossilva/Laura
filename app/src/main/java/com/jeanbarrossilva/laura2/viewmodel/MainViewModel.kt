package com.jeanbarrossilva.laura2.viewmodel

import android.graphics.Color
import androidx.compose.material.ExperimentalMaterialApi
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.laura2.activities.MainActivity

class MainViewModel @ExperimentalMaterialApi constructor(private val activity: MainActivity) : ViewModel() {
	fun configAppearance() {
		activity.window?.statusBarColor = Color.BLACK
		activity.window?.navigationBarColor = Color.BLACK
	}
}