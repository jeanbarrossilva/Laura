package com.jeanbarrossilva.laura.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

object AppCompatActivityX {
    val AppCompatActivity.currentFragment: Fragment?
        get() {
            val (fragments, navHost) = supportFragmentManager.fragments.let { it to it.filterIsInstance<NavHostFragment>().firstOrNull() }
            return navHost?.childFragmentManager?.fragments?.first() ?: fragments.firstOrNull()
        }
}