package com.jeanbarrossilva.laura.ui.viewmodel

import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.activities.MainActivity
import com.jeanbarrossilva.laura.extension.BalanceInfluenceX.withRegistrationDate
import com.jeanbarrossilva.laura.ui.component.BalanceInfluenceIconView
import com.jeanbarrossilva.laura.ui.component.BalanceInfluenceTableLayout
import com.jeanbarrossilva.laura.ui.component.LauraTextView
import com.jeanbarrossilva.laura.ui.fragment.BalanceInfluenceFragment
import com.jeanbarrossilva.laurafoundation.data.ComponentEditor
import com.jeanbarrossilva.laura.extension.EditTextX.focusWithInput
import com.jeanbarrossilva.laurafoundation.implementation.FabConfigurator

class BalanceInfluenceViewModel(private val fragment: BalanceInfluenceFragment) : ViewModel(), FabConfigurator<BalanceInfluenceViewModel> {
    private val influence = fragment.navArgs.influence
    private val componentEditor = ComponentEditor(fragment).also { MainActivity.currentComponentEditor = it }

    private var titleView: EditText? = null

    override fun configFab(view: ImageButton) {
        with(componentEditor) {
            view.setOnClickListener {
                changeState()
                if (state().value?.isEditing() == true) titleView?.focusWithInput()
            }

            observe({ state() }) {
                view.setImageResource(it?.ifEditing { R.drawable.ic_check } ?: R.drawable.ic_edit)
            }
        }
    }

    fun showInfoIn(iconView: BalanceInfluenceIconView, titleView: LauraTextView, registrationDateView: TextView) {
        iconView.setImageResource(influence.icon)

        with(titleView) {
            this@BalanceInfluenceViewModel.titleView = this
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