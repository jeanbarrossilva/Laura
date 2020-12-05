package com.jeanbarrossilva.laura2.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import com.jeanbarrossilva.laura2.ui.component.BalanceInfluenceCard
import com.jeanbarrossilva.laura2.ui.component.WalletInfoCardFor
import com.jeanbarrossilva.laura2.ui.component.provider.WalletPreviewParameterProvider
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.Wallet

@ExperimentalMaterialApi
@Composable
@Preview
fun WalletUI(
    navController: NavHostController? = null,
    modifierBottomSheetState: ModalBottomSheetState? = null,
    @PreviewParameter(WalletPreviewParameterProvider::class) wallet: Wallet
) {
    LauraTheme.Fill {
        LazyColumn {
            item {
                WalletInfoCardFor(wallet) {
                    modifierBottomSheetState?.show()
                }
            }

            items(wallet.influences) { influence ->
                BalanceInfluenceCard(wallet, influence) {
                }
            }
        }
    }
}