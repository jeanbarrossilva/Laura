package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.jeanbarrossilva.laura2.extension.NavControllerX.isRoute
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@Composable
fun NavigatorModalDrawerLayoutItem(
	modifier: Modifier = Modifier,
	navController: NavController,
	icon: ImageVector,
	title: String = "",
	route: String,
	isSelected: Boolean = false,
	onSelect: () -> Unit = { }
) {
	LauraTheme.Wrap {
		ModalDrawerLayoutItem(
			modifier,
			icon = icon,
			title = title,
			isSelected = isSelected
		) {
			if (!navController.isRoute(route)) navController.navigate(route)
			onSelect()
		}
	}
}