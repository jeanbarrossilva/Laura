package com.jeanbarrossilva.laura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jeanbarrossilva.lauraui.viewmodel.MainViewModel
import com.jeanbarrossilva.lauraui.viewmodel.factory.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel> { MainViewModelFactory(this, R.id.container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.run {
            welcome()
            setupActionBar(view = toolbar, navigation_view, drawer_layout)
        }
    }

    override fun onBackPressed() = if (drawer_layout.isOpen) drawer_layout.close() else super.onBackPressed()
}