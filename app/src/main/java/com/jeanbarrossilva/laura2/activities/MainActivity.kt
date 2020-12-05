package com.jeanbarrossilva.laura2.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.focus.ExperimentalFocus
import androidx.compose.ui.platform.setContent
import com.jeanbarrossilva.laura2.ui.MainUI
import com.jeanbarrossilva.laura2.viewmodel.MainViewModel
import com.jeanbarrossilva.laura2.viewmodel.factory.MainViewModelFactory

@ExperimentalMaterialApi
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel> { MainViewModelFactory(activity = this) }

    @ExperimentalLayout
    @ExperimentalFocus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.configAppearance()

        setContent {
            MainUI()
        }
    }
}