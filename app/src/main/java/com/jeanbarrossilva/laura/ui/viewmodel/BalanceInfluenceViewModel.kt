package com.jeanbarrossilva.laura.ui.viewmodel

import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.laura.activities.MainActivity
import com.jeanbarrossilva.laura.ext.BalanceInfluenceX.withRegistrationDate
import com.jeanbarrossilva.laura.ui.component.BalanceInfluenceIconView
import com.jeanbarrossilva.laura.ui.component.BalanceInfluenceTableLayout
import com.jeanbarrossilva.laura.ui.component.LauraTextView
import com.jeanbarrossilva.laura.ui.fragment.BalanceInfluenceFragment
import com.jeanbarrossilva.laurafoundation.data.ComponentEditor

class BalanceInfluenceViewModel(private val fragment: BalanceInfluenceFragment) : ViewModel() {
    private val influence = fragment.navArgs.influence

    internal val componentEditor = ComponentEditor(fragment).also { MainActivity.currentComponentEditor = it }

    fun showInfoIn(iconView: BalanceInfluenceIconView, titleView: LauraTextView, registrationDateView: TextView) {
        iconView.setImageResource(influence.icon)

        with(titleView) {
            setText(influence.name)
            withStateOf(componentEditor)
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