package com.jeanbarrossilva.laura2.ui

import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.material.DrawerState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.focus.ExperimentalFocus
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.jeanbarrossilva.laura2.R
import com.jeanbarrossilva.laura2.extension.NavControllerX.currentRoute
import com.jeanbarrossilva.laura2.ui.component.LauraScaffold
import com.jeanbarrossilva.laura2.ui.component.NavigatorModalDrawerLayoutItem
import com.jeanbarrossilva.laura2.ui.component.WalletModifierModalBottomSheetLayout
import com.jeanbarrossilva.laura2.ui.constants.MainUIConstants.ARG_BALANCE_INFLUENCE
import com.jeanbarrossilva.laura2.ui.constants.MainUIConstants.HOME_ROUTE
import com.jeanbarrossilva.laura2.ui.constants.MainUIConstants.ROUTE_BALANCE_INFLUENCE
import com.jeanbarrossilva.laura2.ui.constants.MainUIConstants.ROUTE_BALANCE_INFLUENCE_COMPOSER_UI
import com.jeanbarrossilva.laura2.ui.constants.MainUIConstants.ROUTE_WALLET_UI
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.default.ObjectBox

@ExperimentalLayout
@ExperimentalFocus
@ExperimentalMaterialApi
@Composable
fun MainUI() {
    val navController = rememberNavController()
    val walletModifierBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
	var toolbarIcon by remember { mutableStateOf(Icons.Rounded.Menu) }
    var onToolbarButtonClick: (DrawerState) -> Unit by mutableStateOf({ _ -> })
    var toolbarTitle by remember { mutableStateOf("") }
    var fabIcon by remember { mutableStateOf(Icons.Rounded.Add) }
    var onFabClick by mutableStateOf({ })
    val wallet = ObjectBox.walletBox.all.first()

    LauraTheme.Fill {
        WalletModifierModalBottomSheetLayout(wallet, walletModifierBottomSheetState) {
            LauraScaffold(
                toolbarIcon,
                onToolbarButtonClick = { drawerState -> onToolbarButtonClick(drawerState) },
                toolbarTitle,
                drawerItems = {
                    NavigatorModalDrawerLayoutItem(
                        navController = navController,
                        icon = vectorResource(R.drawable.ic_account_balance_wallet),
                        title = stringResource(R.string.TopAppBar_title_wallets),
                        route = ROUTE_WALLET_UI,
                        isSelected = true
                    )
                },
                fabIcon,
                onFabClick
            ) {
                NavHost(navController, startDestination = HOME_ROUTE) {
                    val isHomeRoute = navController.currentRoute == HOME_ROUTE

                    toolbarIcon = if (isHomeRoute) Icons.Rounded.Menu else Icons.Rounded.ArrowBack
                    onToolbarButtonClick = { drawerState ->
                        when (isHomeRoute) {
                            true -> if (drawerState.isClosed) drawerState.open() else drawerState.close()
                            false -> navController.popBackStack()
                        }
                    }

                    composable(ROUTE_WALLET_UI) {
                        toolbarTitle = stringResource(R.string.TopAppBar_title_wallets)
                        fabIcon = Icons.Rounded.Add
                        onFabClick = { navController.navigate(ROUTE_BALANCE_INFLUENCE_COMPOSER_UI) }

                        WalletUI(navController, walletModifierBottomSheetState, wallet)
                    }

                    composable(ROUTE_BALANCE_INFLUENCE) { entry ->
                        toolbarTitle = ""
                        onToolbarButtonClick = { navController.popBackStack() }
                        fabIcon = Icons.Rounded.Edit
                        onFabClick = { TODO() }

                        entry.arguments?.getLong(ARG_BALANCE_INFLUENCE)?.let { influenceId ->
                            BalanceInfluenceUI(
                                wallet,
                                wallet.influences.find { influence -> influence.id == influenceId }!!
                            )
                        }
                    }

                    composable(ROUTE_BALANCE_INFLUENCE_COMPOSER_UI) {
                        toolbarTitle = stringResource(R.string.TopAppBar_title_new_acquisition)
                        fabIcon = Icons.Rounded.Check
                        onFabClick = { TODO() }

                        BalanceInfluenceComposerUI(wallet.currency)
                    }
                }
            }
        }
    }
}