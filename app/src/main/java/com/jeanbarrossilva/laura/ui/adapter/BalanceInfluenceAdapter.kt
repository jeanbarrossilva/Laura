package com.jeanbarrossilva.laura.ui.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.activities.MainActivity
import com.jeanbarrossilva.laura.extension.BalanceInfluenceX.formattedAmount
import com.jeanbarrossilva.laura.ui.viewholder.BalanceInfluenceViewHolder
import com.jeanbarrossilva.laura.data.BalanceInfluence
import com.jeanbarrossilva.laura.extension.ContextX.colorAttr

class BalanceInfluenceAdapter(private val onInfluenceClick: (BalanceInfluence) -> Unit) :
    RecyclerView.Adapter<BalanceInfluenceViewHolder>() {
    private var didAddTrackerSelectionObserver = false

    var influences = emptyList<BalanceInfluence>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    lateinit var tracker: SelectionTracker<Long>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context).inflate(R.layout.view_balance_influence, parent, false).let { view ->
            BalanceInfluenceViewHolder(view)
        }

    @Suppress("SetTextI18n")
    override fun onBindViewHolder(holder: BalanceInfluenceViewHolder, position: Int) {
        influences[position].let { influence ->
            holder.name.text = influence.name
            holder.price.text = influence.formattedAmount
            holder.icon.setImageResource(influence.icon)
            holder.itemView.setOnClickListener { onInfluenceClick(influence) }

            with(holder.indicator) {
                val tint = if (influence.decreases) android.R.color.holo_red_light else android.R.color.holo_green_light
                val rotation = if (influence.decreases) 90f else -90f

                this.rotation = rotation
                imageTintList = ColorStateList.valueOf(context.getColor(tint))
            }

            onSelect(influence) { isSelected ->
                with(holder.itemView.context) {
                    val primaryOrInverseColor = colorAttr(if (isSelected) android.R.attr.textColorPrimaryInverse else android.R.attr.textColorPrimary)
                    val backgroundColor =
                        if (isSelected) getColor(R.color.selectedBalanceInfluenceBackground) else colorAttr(android.R.attr.colorBackground)
                    val iconBackgroundColor =
                        getColor(if (isSelected) R.color.selectedBalanceInfluenceIconBackground else R.color.balanceInfluenceIconBackground)
                    val icon = if (isSelected) R.drawable.ic_check else influence.icon

                    holder.itemView.setBackgroundColor(backgroundColor)
                    listOf(holder.name, holder.price).forEach { it.setTextColor(primaryOrInverseColor) }

                    with(holder.icon) {
                        imageTintList = ColorStateList.valueOf(primaryOrInverseColor)
                        backgroundTintList = ColorStateList.valueOf(iconBackgroundColor)
                        setImageResource(icon)
                    }
                }
            }
        }
    }

    override fun getItemId(position: Int) = influences[position].id

    override fun getItemCount() = influences.size

    private fun onSelect(influence: BalanceInfluence, block: (Boolean) -> Unit) {
        val isSelected = tracker.isSelected(influence.id)

        val selectionObserver = object : SelectionTracker.SelectionObserver<Long>() {
            override fun onSelectionChanged() {
                val listener = MainActivity.balanceInfluenceSelectionListener
                val selectedInfluences = tracker.selection.map { id -> LauraApplication.database.balanceInfluenceDao().identifiedAs(id) }

                super.onSelectionChanged()
                if (tracker.hasSelection()) listener.onBeginWith(selectedInfluences) else listener.onEnd()
            }
        }

        if (!didAddTrackerSelectionObserver) tracker.addObserver(selectionObserver).also { didAddTrackerSelectionObserver = true }
        block(isSelected)
    }

    init {
        setHasStableIds(true)
    }
}