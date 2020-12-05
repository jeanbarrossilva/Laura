package com.jeanbarrossilva.laura2.ui.component

import android.text.InputType
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.jeanbarrossilva.laura2.R
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.BalanceInfluenceType
import com.jeanbarrossilva.lauradata.Wallet

@ExperimentalMaterialApi
@Composable
fun WalletModifierModalBottomSheetLayout(wallet: Wallet, state: ModalBottomSheetState, content: @Composable () -> Unit) {
	val context = AmbientContext.current

	LauraTheme.Wrap {
		ModalBottomSheetLayout(
			sheetContent = {
				ModalBottomSheetLayoutItem(
					state,
					icon = vectorResource(R.drawable.ic_account_balance_wallet),
					title = stringResource(R.string.WalletModifier_item_new_wallet)
				)

				ModalBottomSheetLayoutItem(
					state,
					icon = vectorResource(R.drawable.ic_attach_money),
					title = stringResource(R.string.WalletModifier_item_add_quantity)
				) {
					MaterialDialog(context).show {
						title(R.string.WalletModifier_item_add_quantity)
						message(text = context.getString(R.string.WalletModifier_dialog_message_add_quantity).format(wallet.name))

						input(hintRes = R.string.WalletModifier_dialog_hint_add_quantity, inputType = InputType.TYPE_CLASS_NUMBER) { _, value ->
							wallet.influences.add(
								BalanceInfluence(
									type = BalanceInfluenceType.Rise,
									name = context.getString(R.string.BalanceInfluence_title_rise),
									amount = value.toString().toFloat()
								)
							)
						}

						positiveButton(android.R.string.ok) { dismiss() }
						negativeButton(android.R.string.cancel) { dismiss() }
					}

					state.hide()
				}
			},
			sheetState = state,
			sheetShape = RectangleShape
		) {
			content()
		}
	}
}