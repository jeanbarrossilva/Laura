package com.jeanbarrossilva.laura2.extension

import androidx.navigation.NavController
import androidx.navigation.compose.KEY_ROUTE

object NavControllerX {
	fun NavController.isRoute(route: String) = currentBackStackEntry?.arguments?.getString(KEY_ROUTE) == route
}