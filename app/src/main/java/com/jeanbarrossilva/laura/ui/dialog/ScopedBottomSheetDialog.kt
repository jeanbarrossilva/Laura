package com.jeanbarrossilva.laura.ui.dialog

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ui.adapter.BottomSheetDialogItemAdapter
import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogItem
import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogScope
import kotlinx.android.synthetic.main.bottom_sheet_dialog_items.*

class ScopedBottomSheetDialog(context: Context, scope: BottomSheetDialogScope, val onItemClick: (BottomSheetDialogItem) -> Unit)
    : BottomSheetDialog(context) {
    init {
        setContentView(R.layout.bottom_sheet_dialog_items)

        itemsView.layoutManager = LinearLayoutManager(context)
        itemsView.adapter = BottomSheetDialogItemAdapter(dialog = this, scope.items) { item -> onItemClick(item) }
    }
}