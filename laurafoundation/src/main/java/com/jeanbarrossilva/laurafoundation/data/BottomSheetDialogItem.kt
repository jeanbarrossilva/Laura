package com.jeanbarrossilva.laurafoundation.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jeanbarrossilva.laurafoundation.R

sealed class BottomSheetDialogItem(@DrawableRes val icon: Int, @StringRes val title: Int) {
    object NewWalletItem : BottomSheetDialogItem(
        icon = R.drawable.ic_account_balance_wallet,
        title = R.string.bottom_sheet_dialog_item_title_new_wallet
    )

    object AddQuantityItem : BottomSheetDialogItem(
        icon = R.drawable.ic_attach_money,
        title = R.string.bottom_sheet_dialog_item_title_add_quantity
    )
}