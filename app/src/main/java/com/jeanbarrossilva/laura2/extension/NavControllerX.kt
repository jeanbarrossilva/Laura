package com.jeanbarrossilva.laura2.extension

import androidx.navigation.NavController
import androidx.navigation.compose.KEY_ROUTE

object NavControllerX {
	val NavController.currentRoute get() = currentBackStackEntry?.arguments?.getString(KEY_ROUTE)

	fun NavController.isRoute(route: String) = currentRoute == route
}