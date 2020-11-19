package com.jeanbarrossilva.laura.ui.viewmodel

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
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.LauraApplication.Companion.acquirer
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.activities.MainActivity
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.balanceInfluenceSelectionListener
import com.jeanbarrossilva.laura.extension.AcquirerX.currentWallet
import com.jeanbarrossilva.laura.extension.AppCompatActivityX.currentFragment
import com.jeanbarrossilva.laura.extension.BalanceInfluenceX.unregister
import com.jeanbarrossilva.laura.extension.FragmentX.reload
import com.jeanbarrossilva.laura.extension.MenuX.addIfNotAdded
import com.jeanbarrossilva.laura.ui.listener.BalanceInfluenceSelectionListener
import com.jeanbarrossilva.laura.data.BalanceInfluence
import com.jeanbarrossilva.laura.data.Wallet

class MainViewModel(private val activity: MainActivity) : ViewModel() {
    private val preferences = PreferenceManager.getDefaultSharedPreferences(activity)
    private val navController = activity.findNavController(R.id.container)

    fun welcome() {
        ifIsFirstLaunch {
            navController.navigate(R.id.action_global_onboardingFragment)
            LauraApplication.database.walletDao().add(Wallet.main)
            acquirer.currentWallet = Wallet.main
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

        toggleActionsForBalanceInfluenceSelectionIn(view)
    }

    private fun toggleActionsForBalanceInfluenceSelectionIn(view: Toolbar) {
        balanceInfluenceSelectionListener = object : BalanceInfluenceSelectionListener {
            val previousTitle = view.title

            override fun onBeginWith(influences: List<BalanceInfluence>) {
                view.title = activity.getString(R.string.toolbar_label_selected_items).format(influences.size)

                listOf(
                    Triple(R.drawable.ic_delete, R.string.toolbar_action_delete, { for (influence in influences) influence.unregister() })
                ).forEachIndexed { index, (icon, title, onClick) ->
                    view.menu.addIfNotAdded(itemId = index, order = index, titleRes = title) { onClick(); onEnd() }?.setIcon(icon)
                }
            }

            override fun onEnd() {
                with(view) {
                    title = previousTitle
                    menu.clear()
                }

                activity.currentFragment?.reload()
            }
        }
    }
}