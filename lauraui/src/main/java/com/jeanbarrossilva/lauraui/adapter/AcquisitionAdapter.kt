package com.jeanbarrossilva.lauraui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laurafoundation.ext.AcquisitionX.formattedValue
import com.jeanbarrossilva.lauraui.R
import com.jeanbarrossilva.lauraui.viewholder.AcquisitionViewHolder

class AcquisitionAdapter(private val acquisitions: List<Acquisition>) : RecyclerView.Adapter<AcquisitionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context).inflate(R.layout.view_acquisition, parent, false).let { view -> AcquisitionViewHolder(view) }

    @Suppress("SetTextI18n")
    override fun onBindViewHolder(holder: AcquisitionViewHolder, position: Int) {
        acquisitions[position].let { acquisition ->
            holder.name.text = acquisition.name
            holder.price.text = "${acquisition.currency.symbol} ${acquisition.formattedValue}"
            holder.icon.setImageResource(acquisition.category.icon)
        }
    }

    override fun getItemCount() = acquisitions.size
}