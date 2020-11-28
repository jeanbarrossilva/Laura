package com.jeanbarrossilva.laura2.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.ui.tooling.preview.PreviewParameter
import com.jeanbarrossilva.laura2.LauraApplication
import com.jeanbarrossilva.lauradata.Wallet
import com.jeanbarrossilva.laura2.ui.component.BalanceInfluenceCardFor
import com.jeanbarrossilva.laura2.ui.component.WalletInfoCardFor
import com.jeanbarrossilva.laura2.ui.component.provider.WalletPreviewParameterProvider
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@ExperimentalMaterialApi
@Composable
// TODO: Attach acquisitions to the Wallet class and remove BalanceInfluenceDao.
/* Preview won't work because BalanceInfluences ("influences") are obtained from LauraApplication.database, which is initialized only when the app is
 * launched. */
fun WalletUI(
    navController: NavHostController? = null,
    modifierBottomSheetState: ModalBottomSheetState,
    @PreviewParameter(WalletPreviewParameterProvider::class) wallet: Wallet
) {
    val influences by LauraApplication.database.balanceInfluenceDao().all().observeAsState()

    LauraTheme.Fill {
        Box(Modifier.fillMaxSize()) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                WalletInfoCardFor(wallet) {
                    modifierBottomSheetState.show()
                }

                LazyColumnFor(influences ?: emptyList()) { influence ->
                    BalanceInfluenceCardFor(influence) {
                    }
                }
            }
        }
    }
}