package com.jeanbarrossilva.lauraui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laurafoundation.data.AcquisitionCategory
import kotlinx.android.synthetic.main.view_acquisition.view.*

class AcquisitionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val icon: ImageView = view.icon
    val name: TextView = view.name
    val price: TextView = view.price
}