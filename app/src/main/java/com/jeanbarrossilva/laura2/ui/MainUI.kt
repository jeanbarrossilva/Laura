package com.jeanbarrossilva.laura2.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.*
import com.jeanbarrossilva.laura2.R
import com.jeanbarrossilva.laura2.ui.component.LauraScaffold
import com.jeanbarrossilva.laura2.ui.component.NavigatorModalDrawerLayoutItem
import com.jeanbarrossilva.laura2.ui.constants.MainUIConstants
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.Wallet

@ExperimentalMaterialApi
@Composable
fun MainUI() {
    val navController = rememberNavController()
    var toolbarTitle by remember { mutableStateOf("") }

    LauraTheme.Fill {
        LauraScaffold(
            toolbarTitle,
            drawerItems = {
                NavigatorModalDrawerLayoutItem(
                    navController = navController,
                    icon = vectorResource(R.drawable.ic_account_balance_wallet),
                    title = stringResource(R.string.Screen_label_wallets),
                    route = MainUIConstants.ROUTE_WALLETS_UI,
                    isSelected = true
                )
            },
            fabIcon = Icons.Rounded.Add
        ) {
            NavHost(navController, startDestination = MainUIConstants.ROUTE_WALLETS_UI) {
                composable("wallets") {
                    toolbarTitle = stringResource(R.string.Screen_label_wallets)

                    // TODO: Change listOf(Wallet.main) to LauraApplication.database.walletDao().all() to allow multiple wallets.
                    WalletsUI(navController, listOf(Wallet.main))
                }
            }
        }
    }
}