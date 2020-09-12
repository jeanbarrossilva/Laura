package com.jeanbarrossilva.lauraui.viewholder

import android.view.View
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laurafoundation.data.AcquisitionCategory
import com.jeanbarrossilva.laurafoundation.ext.LocalDateTimeX.isSameDayAs
import com.jeanbarrossilva.lauraui.R
import kotlinx.android.synthetic.main.view_acquisition.view.*
import java.text.DateFormat

class AcquisitionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val flightDateTime: TextView = view.flight_date_time

    val icon: ImageView = view.icon
    val name: TextView = view.name
    val currencySymbol: TextView = view.currency_symbol
    val value: TextView = view.value

    fun fillFlightFieldWith(acquisition: Acquisition) {
        val flight = acquisition.category as AcquisitionCategory.FlightTicket
        val dateFormat = DateFormat.getDateInstance()
        val takeOffDetails = "${dateFormat.format(flight.takeOff)}, ${flight.takeOffTime}"
        val landingDetails = with(flight) { if (landing isSameDayAs takeOff) landingTime else "${dateFormat.format(landing)}, $landingTime" }

        flightDateTime.apply {
            text = view.context.getString(R.string.placeholder_flight_duration).format(takeOffDetails, landingDetails)
            visibility = VISIBLE
        }
    }
}