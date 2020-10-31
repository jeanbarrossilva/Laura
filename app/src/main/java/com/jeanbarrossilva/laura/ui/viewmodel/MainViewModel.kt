package com.jeanbarrossilva.laura.ui.viewmodel

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
import com.github.javiersantos.piracychecker.enums.Display.DIALOG
import com.github.javiersantos.piracychecker.enums.InstallerID.GOOGLE_PLAY
import com.github.javiersantos.piracychecker.piracyChecker
import com.google.android.material.navigation.NavigationView
import com.jeanbarrossilva.laura.BuildConfig.DEBUG
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.LauraApplication.Companion.acquirer
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.Key
import com.jeanbarrossilva.laurafoundation.data.Wallet

class MainViewModel(private val activity: AppCompatActivity) : ViewModel() {
    private val preferences = PreferenceManager.getDefaultSharedPreferences(activity)
    private val navController = activity.findNavController(R.id.container)

    fun piracyCheck() {
        if (!DEBUG) {
            activity.piracyChecker {
                saveResultToSharedPreferences(preferences, "isLegit")
                enableGooglePlayLicensing(Key.googlePlayLicense)
                enableSigningCertificate(Key.certificate)
                enableInstallerId(GOOGLE_PLAY)
                enableUnauthorizedAppsCheck()
                enableFoldersCheck()
                enableStoresCheck()
                enableAPKCheck()

                display(DIALOG)
                start()
            }
        }
    }

    fun welcome() {
        ifIsFirstLaunch {
            navController.navigate(R.id.action_global_onboardingFragment)
            LauraApplication.database.walletDao().add(Wallet.main)
            acquirer.currentWalletId = Wallet.main.id
        }
    }

    fun setupActionBar(view: Toolbar, navigationView: NavigationView, drawer: DrawerLayout) {
        setupToolbar(view, drawer)
        navigationView.setupWithNavController(navController)
    }
    
    private fun ifIsFirstLaunch(block: () -> Unit) {
        val isIt = preferences.getBoolean("isFirstLaunch", true)

        if (isIt) {
            block()
            preferences.edit { putBoolean("isFirstLaunch", false) }
        }
    }
    
    private fun setupToolbar(view: Toolbar, drawer: DrawerLayout) {
        activity.setSupportActionBar(view)
        view.setNavigationOnClickListener { drawer.open() }
        view.menu.forEach { if (it.itemId == R.id.walletFragment) it.isChecked = true }
        AppBarConfiguration(navController.graph, drawer).let { config -> view.setupWithNavController(navController, config) }
    }
}