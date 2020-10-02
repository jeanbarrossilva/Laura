package com.jeanbarrossilva.laura.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_acquisition.view.*

class AcquisitionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val icon: ImageView = view.icon
    val name: TextView = view.name
    val price: TextView = view.price
}