package com.jeanbarrossilva.laura.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.github.javiersantos.piracychecker.piracyChecker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ui.viewmodel.MainViewModel
import com.jeanbarrossilva.laura.ui.viewmodel.factory.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel> { MainViewModelFactory(activity = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        companionFab = fab

        viewModel.run {
            piracyCheck()
            welcome()
            setupActionBar(toolbar, navigationView, drawerLayout)
        }
    }

    override fun onBackPressed() = if (drawerLayout.isOpen) drawerLayout.close() else super.onBackPressed()

    override fun onDestroy() {
        super.onDestroy()
        piracyChecker { destroy() }
    }

    companion object {
        private lateinit var companionFab: FloatingActionButton

        fun withFab(block: FloatingActionButton.() -> Unit) = if (this::companionFab.isInitialized) block(companionFab) else null
    }
}