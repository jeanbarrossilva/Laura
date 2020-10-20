package com.jeanbarrossilva.laurafoundation.data

import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogItem.*

sealed class BottomSheetDialogScope(val items: List<BottomSheetDialogItem>) {
    object WalletModifierScope : BottomSheetDialogScope(listOf(NewWalletItem, AddQuantityItem))
}