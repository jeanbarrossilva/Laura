package com.jeanbarrossilva.laura.ui.viewmodel

import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ext.BalanceInfluenceX.formattedAmount
import com.jeanbarrossilva.laura.ext.BalanceInfluenceX.withRegistrationDate
import com.jeanbarrossilva.laura.ui.component.BalanceInfluenceIconView
import com.jeanbarrossilva.laura.ui.component.BalanceInfluenceTableCellView
import com.jeanbarrossilva.laura.ui.fragment.BalanceInfluenceFragment
import com.jeanbarrossilva.laurafoundation.ext.SequenceX.withEach

class BalanceInfluenceViewModel(private val fragment: BalanceInfluenceFragment) : ViewModel() {
    private val influence = fragment.navArgs.influence

    fun showHeaderInfoIn(iconView: BalanceInfluenceIconView, titleView: TextView, registrationDateView: TextView) {
        titleView.text = influence.name
        iconView.setImageResource(influence.icon)

        influence.withRegistrationDate(fragment.context) { standard, extended ->
            with(registrationDateView) {
                text = standard
                setOnClickListener { text = if (text == standard) extended else standard }
            }
        }
    }

    fun configCellsOf(view: LinearLayout) {
        view.children.map { it as BalanceInfluenceTableCellView }.withEach {
            when (id) {
                R.id.amountCell -> {
                    representation = influence.formattedAmount
                    setTitle(if (influence.decreases) R.string.cost else R.string.amount)
                }
            }
        }
    }
}