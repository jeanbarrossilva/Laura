package com.jeanbarrossilva.laura.ui.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ext.BalanceInfluenceX.wallet
import com.jeanbarrossilva.laura.ui.viewholder.BalanceInfluenceViewHolder
import com.jeanbarrossilva.laurafoundation.LauraFoundation
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence

class BalanceInfluenceAdapter(val influences: List<BalanceInfluence>) : RecyclerView.Adapter<BalanceInfluenceViewHolder>() {
    lateinit var tracker: SelectionTracker<Long>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context).inflate(R.layout.view_balance_influence, parent, false).let { view ->
            BalanceInfluenceViewHolder(view)
        }

    @Suppress("SetTextI18n")
    override fun onBindViewHolder(holder: BalanceInfluenceViewHolder, position: Int) {
        influences[position].let { influence ->
            holder.name.text = influence.name
            holder.price.text = "${influence.currency.symbol} ${LauraFoundation.currencyFormat.format(influence.amount)}"
            holder.icon.setImageResource(influence.icon)

            with(holder.indicator) {
                val tint = if (influence.decreases) android.R.color.holo_red_light else android.R.color.holo_green_light
                val rotation = if (influence.decreases) 90f else -90f

                this.rotation = rotation
                imageTintList = ColorStateList.valueOf(context.getColor(tint))
            }
        }
    }

    override fun getItemCount() = influences.size
}