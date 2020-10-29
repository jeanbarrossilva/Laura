package com.jeanbarrossilva.laura.ui.detailslookup

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laura.ui.adapter.BalanceInfluenceAdapter

class AcquisitionDetailsLookup(private val view: RecyclerView) : ItemDetailsLookup<Long>() {
    override fun getItemDetails(event: MotionEvent): ItemDetails<Long>? {
        val selectedItem = view.findChildViewUnder(event.x, event.y)
        val holder = view.getChildViewHolder(selectedItem!!)

        return object : ItemDetails<Long>() {
            override fun getPosition() = holder.adapterPosition

            override fun getSelectionKey() = (view.adapter as? BalanceInfluenceAdapter)?.influences?.get(position)?.id
        }
    }
}