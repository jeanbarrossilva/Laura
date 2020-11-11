package com.jeanbarrossilva.laura.ui.viewmodel

import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.laura.ext.BalanceInfluenceX.withRegistrationDate
import com.jeanbarrossilva.laura.ui.component.BalanceInfluenceIconView
import com.jeanbarrossilva.laura.ui.component.BalanceInfluenceTableLayout
import com.jeanbarrossilva.laura.ui.component.LauraTextView
import com.jeanbarrossilva.laura.ui.fragment.BalanceInfluenceFragment

class BalanceInfluenceViewModel(private val fragment: BalanceInfluenceFragment) : ViewModel() {
    private val influence = fragment.navArgs.influence

    fun showInfoIn(iconView: BalanceInfluenceIconView, titleView: LauraTextView, registrationDateView: TextView) {
        iconView.setImageResource(influence.icon)

        with(titleView) {
            componentEditor = fragment
            setText(influence.name)
        }

        influence.withRegistrationDate(fragment.context) { standard, extended ->
            with(registrationDateView) {
                text = standard
                setOnClickListener { text = if (text == standard) extended else standard }
            }
        }
    }

    fun configTableLayout(view: BalanceInfluenceTableLayout) = view.apply { influence = this@BalanceInfluenceViewModel.influence }
}