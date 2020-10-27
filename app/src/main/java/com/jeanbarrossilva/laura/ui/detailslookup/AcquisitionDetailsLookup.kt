package com.jeanbarrossilva.laura.ui.detailslookup

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laura.ui.adapter.AcquisitionAdapter
import com.jeanbarrossilva.laurafoundation.data.Acquisition

class AcquisitionDetailsLookup(private val view: RecyclerView) : ItemDetailsLookup<Acquisition>() {
    override fun getItemDetails(event: MotionEvent): ItemDetails<Acquisition>? {
        val selectedItem = view.findChildViewUnder(event.x, event.y)
        val holder = view.getChildViewHolder(selectedItem!!)

        return object : ItemDetails<Acquisition>() {
            override fun getPosition() = holder.adapterPosition

            override fun getSelectionKey() = (view.adapter as? AcquisitionAdapter)?.acquisitions?.get(position)
        }
    }
}