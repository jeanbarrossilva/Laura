package com.jeanbarrossilva.laura.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.Selection
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laura.ui.viewholder.AcquisitionViewHolder
import com.jeanbarrossilva.laurafoundation.LauraFoundation

class AcquisitionAdapter(val acquisitions: List<Acquisition>) : RecyclerView.Adapter<AcquisitionViewHolder>() {
    lateinit var tracker: SelectionTracker<Acquisition>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context).inflate(R.layout.view_acquisition, parent, false).let { view -> AcquisitionViewHolder(view) }

    @Suppress("SetTextI18n")
    override fun onBindViewHolder(holder: AcquisitionViewHolder, position: Int) {
        acquisitions[position].let { acquisition ->
            holder.name.text = acquisition.name
            holder.price.text = "${acquisition.currency.symbol} ${LauraFoundation.currencyFormat.format(acquisition.price)}"
        }
    }

    override fun getItemCount() = acquisitions.size
}