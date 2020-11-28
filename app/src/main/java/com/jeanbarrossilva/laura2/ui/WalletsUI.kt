package com.jeanbarrossilva.laura2.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.ui.tooling.preview.Preview
import com.jeanbarrossilva.lauradata.Wallet

@ExperimentalMaterialApi
@Composable
@Preview
fun WalletsUI(navController: NavHostController? = null, wallets: List<Wallet> = emptyList()) {
	WalletUI(navController, wallets.first())
}