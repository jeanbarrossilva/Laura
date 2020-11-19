package com.jeanbarrossilva.laura.data

import com.jeanbarrossilva.laura.data.BottomSheetDialogItem.*

sealed class BottomSheetDialogScope(val items: List<BottomSheetDialogItem>) {
    object WalletModifierScope : BottomSheetDialogScope(listOf(NewWalletItem, AddQuantityItem))
}