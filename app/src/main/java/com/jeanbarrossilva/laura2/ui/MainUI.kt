package com.jeanbarrossilva.laura2.ui

import android.text.InputType
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.*
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.jeanbarrossilva.laura2.R
import com.jeanbarrossilva.laura2.extension.BalanceInfluenceX.register
import com.jeanbarrossilva.laura2.extension.ColumnX.ModalLayoutColumn
import com.jeanbarrossilva.laura2.ui.component.*
import com.jeanbarrossilva.laura2.ui.constants.MainUIConstants
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.Wallet

@ExperimentalMaterialApi
@Composable
fun MainUI() {
    val context = ContextAmbient.current
    val navController = rememberNavController()
    val walletModifierBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    var toolbarTitle by remember { mutableStateOf("") }
    val wallet = Wallet.main

    LauraTheme.Fill {
        ModalBottomSheetLayout(
            sheetContent = {
                ModalLayoutColumn {
                    ModalBottomSheetLayoutItem(
                        icon = vectorResource(R.drawable.ic_account_balance_wallet),
                        title = stringResource(R.string.WalletModifier_item_new_wallet),
                        state = walletModifierBottomSheetState
                    )

                    ModalBottomSheetLayoutItem(
                        icon = vectorResource(R.drawable.ic_attach_money),
                        title = stringResource(R.string.WalletModifier_item_add_quantity),
                        state = walletModifierBottomSheetState
                    ) {
                        MaterialDialog(context).show {
                            title(R.string.WalletModifier_item_add_quantity)
                            message(R.string.WalletModifier_dialog_message_add_quantity)

                            input(hintRes = R.string.WalletModifier_dialog_hint_add_quantity, inputType = InputType.TYPE_CLASS_NUMBER) { _, value ->
                                BalanceInfluence.Rise(
                                    walletId = wallet.id,
                                    name = context.getString(R.string.BalanceInfluence_title_rise),
                                    amount = value.toString().toFloat()
                                ).register()
                                dismiss()
                            }

                            positiveButton(android.R.string.ok) { dismiss() }
                            negativeButton(android.R.string.cancel) { dismiss() }
                        }

                        walletModifierBottomSheetState.hide()
                    }
                }
            },
            sheetState = walletModifierBottomSheetState,
            sheetShape = RectangleShape
        ) {
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
                        WalletUI(navController, walletModifierBottomSheetState, wallet)
                    }
                }
            }
        }
    }
}