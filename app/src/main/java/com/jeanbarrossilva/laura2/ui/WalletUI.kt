package com.jeanbarrossilva.laura2.ui

import android.text.InputType
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.ui.tooling.preview.PreviewParameter
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.jeanbarrossilva.laura2.LauraApplication
import com.jeanbarrossilva.lauradata.Wallet
import com.jeanbarrossilva.laura2.R
import com.jeanbarrossilva.laura2.extension.BalanceInfluenceX.register
import com.jeanbarrossilva.laura2.extension.ColumnX.ModalLayoutColumn
import com.jeanbarrossilva.laura2.ui.component.BalanceInfluenceCardFor
import com.jeanbarrossilva.laura2.ui.component.ModalBottomSheetLayoutItem
import com.jeanbarrossilva.laura2.ui.component.WalletInfoCard
import com.jeanbarrossilva.laura2.ui.component.provider.WalletPreviewParameterProvider
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.BalanceInfluence

@ExperimentalMaterialApi
@Composable
// TODO: Attach acquisitions to the Wallet class and remove BalanceInfluenceDao.
/* Preview won't work because BalanceInfluences ("influences") are obtained from LauraApplication.database, which is initialized only when the app is
 * launched. */
fun WalletUI(navController: NavHostController? = null, @PreviewParameter(WalletPreviewParameterProvider::class) wallet: Wallet) {
    val context = ContextAmbient.current
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    var balance by remember { mutableStateOf(wallet.balance) }
    val influences by LauraApplication.database.balanceInfluenceDao().all().observeAsState()
    val riseName = stringResource(R.string.BalanceInfluence_title_rise)

    LauraTheme.Fill {
        ModalBottomSheetLayout(
            sheetContent = {
                ModalLayoutColumn {
                    ModalBottomSheetLayoutItem(
                        icon = vectorResource(R.drawable.ic_account_balance_wallet),
                        title = stringResource(R.string.WalletModifier_item_new_wallet)
                    )

                    ModalBottomSheetLayoutItem(
                        icon = vectorResource(R.drawable.ic_attach_money),
                        title = stringResource(R.string.WalletModifier_item_add_quantity)
                    ) {


                        MaterialDialog(context).show {
                            title(R.string.WalletModifier_item_add_quantity)
                            message(R.string.WalletModifier_dialog_message_add_quantity)

                            input(hintRes = R.string.WalletModifier_dialog_hint_add_quantity, inputType = InputType.TYPE_CLASS_NUMBER) { _, value ->
                                BalanceInfluence.Rise(walletId = wallet.id, name = riseName, amount = value.toString().toFloat()).register()
                                balance = wallet.balance
                                dismiss()
                            }

                            positiveButton(android.R.string.ok) { dismiss() }
                            negativeButton(android.R.string.cancel) { dismiss() }
                        }

                        bottomSheetState.hide()
                    }
                }
            },
            sheetState = bottomSheetState,
            sheetShape = RectangleShape
        ) {
            Box(Modifier.fillMaxSize()) {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    WalletInfoCard(
                        name = wallet.name,
                        currency = wallet.currency,
                        balance
                    ) {
                        bottomSheetState.show()
                    }

                    LazyColumnFor(influences ?: emptyList()) { influence ->
                        BalanceInfluenceCardFor(influence) {
                        }
                    }
                }
            }
        }
    }
}