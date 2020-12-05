package com.jeanbarrossilva.laura2.ui

import android.text.InputType
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.focus.ExperimentalFocus
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.jeanbarrossilva.laura2.R
import com.jeanbarrossilva.laura2.ui.component.LauraScaffold
import com.jeanbarrossilva.laura2.ui.component.ModalBottomSheetLayoutItem
import com.jeanbarrossilva.laura2.ui.component.NavigatorModalDrawerLayoutItem
import com.jeanbarrossilva.laura2.ui.constants.MainUIConstants
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.BalanceInfluenceType.Rise
import com.jeanbarrossilva.lauradata.default.ObjectBox

@ExperimentalFocus
@ExperimentalMaterialApi
@Composable
fun MainUI() {
    val context = ContextAmbient.current
    val navController = rememberNavController()
    val walletModifierBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    var toolbarTitle by remember { mutableStateOf("") }
    var fabIcon by remember { mutableStateOf(Icons.Rounded.Add) }
    var onFabClick by mutableStateOf({ })
    val wallet = ObjectBox.walletBox.all.first()

    LauraTheme.Fill {
        ModalBottomSheetLayout(
            sheetContent = {
                ModalBottomSheetLayoutItem(
                    walletModifierBottomSheetState,
                    icon = vectorResource(R.drawable.ic_account_balance_wallet),
                    title = stringResource(R.string.WalletModifier_item_new_wallet)
                )

                ModalBottomSheetLayoutItem(
                    walletModifierBottomSheetState,
                    icon = vectorResource(R.drawable.ic_attach_money),
                    title = stringResource(R.string.WalletModifier_item_add_quantity)
                ) {
                    MaterialDialog(context).show {
                        title(R.string.WalletModifier_item_add_quantity)
                        message(text = context.getString(R.string.WalletModifier_dialog_message_add_quantity).format(wallet.name))

                        input(hintRes = R.string.WalletModifier_dialog_hint_add_quantity, inputType = InputType.TYPE_CLASS_NUMBER) { _, value ->
                            wallet.influences.add(
                                BalanceInfluence(
                                    type = Rise,
                                    name = context.getString(R.string.BalanceInfluence_title_rise),
                                    amount = value.toString().toFloat()
                                )
                            )
                        }

                        positiveButton(android.R.string.ok) { dismiss() }
                        negativeButton(android.R.string.cancel) { dismiss() }
                    }

                    walletModifierBottomSheetState.hide()
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
                        route = MainUIConstants.ROUTE_WALLET_UI,
                        isSelected = true
                    )
                },
                fabIcon,
                onFabClick
            ) {
                NavHost(navController, startDestination = MainUIConstants.ROUTE_WALLET_UI) {
                    composable(MainUIConstants.ROUTE_WALLET_UI) {
                        toolbarTitle = stringResource(R.string.Screen_label_wallets)
                        fabIcon = Icons.Rounded.Add
                        onFabClick = { navController.navigate(MainUIConstants.ROUTE_BALANCE_INFLUENCE_COMPOSER_UI) }

                        WalletUI(navController, walletModifierBottomSheetState, wallet)
                    }

                    composable(MainUIConstants.ROUTE_BALANCE_INFLUENCE_COMPOSER_UI) {
                        toolbarTitle = stringResource(R.string.Screen_label_new_acquisition)
                        fabIcon = Icons.Rounded.Check

                        BalanceInfluenceComposerUI(wallet.currency)
                    }
                }
            }
        }
    }
}