package com.jeanbarrossilva.laura.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.ext.AcquisitionX.registerOrWarnIfExpensiveFor
import com.jeanbarrossilva.laura.ext.TextInputEditTextX.required
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laura.ui.fragment.AcquisitionComposerFragment
import com.jeanbarrossilva.laurafoundation.data.Acquirer
import kotlinx.android.synthetic.main.fragment_acquisition_composer.*
import kotlinx.android.synthetic.main.view_acquisition.*
import kotlinx.android.synthetic.main.view_price_field.view.*

class AcquisitionComposerViewModel(private val fragment: AcquisitionComposerFragment) : ViewModel() {
    init {
        fragment.name?.requestFocus()
    }

    fun compose() {
        withFab {
            with(fragment) {
                setOnClickListener {
                    listOf(nameField, priceField?.amountField).forEach { field ->
                        field?.required { "This field is required." }
                    }

                    Acquisition(name = nameField.text.toString(), currency = priceField.currency, price = priceField.amount!!)
                        .registerOrWarnIfExpensiveFor(Acquirer.currentWallet, fragment)
                }
            }
        }
    }
}