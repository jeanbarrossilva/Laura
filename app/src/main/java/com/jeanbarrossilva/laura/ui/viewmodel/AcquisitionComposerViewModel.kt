package com.jeanbarrossilva.laura.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.ext.TextInputEditTextX.onEmpty
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laura.ui.fragment.AcquisitionComposerFragment
import kotlinx.android.synthetic.main.fragment_acquisition_composer.*
import kotlinx.android.synthetic.main.view_acquisition.*
import kotlinx.android.synthetic.main.view_currency_amount.view.*

class AcquisitionComposerViewModel(private val fragment: AcquisitionComposerFragment) : ViewModel() {
    init {
        withFab { hide() }
        fragment.name?.requestFocus()
    }

    fun compose() {
        fragment.addButton?.setOnClickListener {
            listOfNotNull(fragment.nameField, fragment.currencyAmountView.amountField).onEmpty { "This field is required." }

            val composed = Acquisition(name = fragment.nameField.text.toString(), currency = fragment.currencyAmountView.currency,
                value = fragment.currencyAmountView.getAmount()!!)
        }
    }
}