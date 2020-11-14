package com.jeanbarrossilva.laurafoundation.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jeanbarrossilva.laurafoundation.R

sealed class BottomSheetDialogItem(@DrawableRes val icon: Int, @StringRes val title: Int) {
    object NewWalletItem : BottomSheetDialogItem(
        icon = R.drawable.ic_account_balance_wallet,
        title = R.string.WalletModifier_item_new_wallet
    )

    object AddQuantityItem : BottomSheetDialogItem(
        icon = R.drawable.ic_attach_money,
        title = R.string.WalletModifier_dialog_hint_add_quantity
    )
}