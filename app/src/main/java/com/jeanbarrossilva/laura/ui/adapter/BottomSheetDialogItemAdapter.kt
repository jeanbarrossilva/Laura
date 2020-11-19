package com.jeanbarrossilva.laura.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.data.BottomSheetDialogItem
import kotlinx.android.synthetic.main.bottom_sheet_dialog_item.view.*

class BottomSheetDialogItemAdapter(
    private val dialog: BottomSheetDialog,
    private val items: List<BottomSheetDialogItem>,
    private val onClick: (BottomSheetDialogItem) -> Unit
) : RecyclerView.Adapter<BottomSheetDialogItemAdapter.BottomSheetDialogItemViewHolder>() {
    inner class BottomSheetDialogItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.iconView
        val title: TextView = view.titleView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context).inflate(R.layout.bottom_sheet_dialog_item, parent, false).let { view ->
            BottomSheetDialogItemViewHolder(view)
        }

    override fun onBindViewHolder(holder: BottomSheetDialogItemViewHolder, position: Int) {
        items[position].let { item ->
            val context = holder.itemView.context
            val (finalIcon, finalTitle) = ContextCompat.getDrawable(context, item.icon) to context.getString(item.title)

            holder.icon.setImageDrawable(finalIcon)
            holder.title.text = finalTitle

            holder.itemView.setOnClickListener {
                onClick(item)
                dialog.dismiss()
            }
        }
    }

    override fun getItemCount() = items.size
}