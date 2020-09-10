package com.jeanbarrossilva.laura.kit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laura.foundation.AcquisitionCategory.FlightTicket
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ext.AcquisitionX.formattedValue
import com.jeanbarrossilva.laura.foundation.Acquisition

class AcquisitionAdapter(private val acquisitions: List<Acquisition>) : RecyclerView.Adapter<AcquisitionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context).inflate(R.layout.view_acquisition, parent, false).let { view -> AcquisitionViewHolder(view) }

    override fun onBindViewHolder(holder: AcquisitionViewHolder, position: Int) {
        acquisitions[position].let { acquisition ->
            holder.name.text = acquisition.name
            holder.currencySymbol.text = acquisition.currency.symbol
            holder.value.text = acquisition.formattedValue
            holder.icon.setImageResource(acquisition.category.icon)
            if (acquisition.category is FlightTicket) holder.fillFlightFieldWith(acquisition)
        }
    }

    override fun getItemCount() = acquisitions.size
}