package com.jeanbarrossilva.lauraui.viewmodel

import android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.core.view.forEach
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.google.android.material.navigation.NavigationView
import com.jeanbarrossilva.lauraui.R
import com.jeanbarrossilva.lauraui.ext.ContextX.isDark

class MainViewModel(private val activity: AppCompatActivity, @IdRes containerId: Int) : ViewModel() {
    private val preferences = PreferenceManager.getDefaultSharedPreferences(activity)
    private val navController = activity.findNavController(containerId)

    fun welcome() {
        val isFirstLaunch = preferences.getBoolean("isFirstLaunch", true)

        if (isFirstLaunch) {
            navController.navigate(R.id.action_global_onboardingFragment)
            preferences.edit { putBoolean("isFirstLaunch", false) }
        }
    }

    fun setupActionBar(view: Toolbar, navigationView: NavigationView, drawer: DrawerLayout) {
        setupToolbar(view, drawer)
        navigationView.setupWithNavController(navController)
    }

    private fun setupToolbar(view: Toolbar, drawer: DrawerLayout) {
        activity.setSupportActionBar(view)
        view.setNavigationOnClickListener { drawer.open() }
        view.menu.forEach { if (it.itemId == R.id.walletFragment) it.isChecked = true }
        AppBarConfiguration(navController.graph, drawer).let { config -> view.setupWithNavController(navController, config) }
    }
}