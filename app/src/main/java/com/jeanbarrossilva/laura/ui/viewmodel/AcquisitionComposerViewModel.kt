package com.jeanbarrossilva.laura.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.ext.TextInputEditTextX.onEmpty
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laura.ui.fragment.AcquisitionComposerFragment
import com.jeanbarrossilva.laurafoundation.data.Wallet
import kotlinx.android.synthetic.main.fragment_acquisition_composer.*
import kotlinx.android.synthetic.main.view_acquisition.*
import kotlinx.android.synthetic.main.view_currency_amount.view.amountField

class AcquisitionComposerViewModel(private val fragment: AcquisitionComposerFragment) : ViewModel() {
    init {
        withFab { hide() }
        fragment.name?.requestFocus()
    }

    fun compose() {
        fragment.addButton?.setOnClickListener {
            listOfNotNull(fragment.nameField, fragment.priceField.amountField).onEmpty {
                "This field is required."
            }

            val composedAcquisition = Acquisition(
                name = fragment.nameField.text.toString(),
                currency = fragment.priceField.currency,
                price = fragment.priceField.amountField.text.toString().toFloatOrNull()!!
            )

            if (composedAcquisition isExpensiveFor Wallet.main)
                fragment.context?.let {
                    MaterialDialog(it).show {
                        title(text = "Too expensive!")
                        message(text = "This acquisition will let your ${Wallet.main.name} wallet with a negative balance. Are you sure you " +
                                "want to register?")

                        positiveButton(android.R.string.ok) { register(composedAcquisition) }
                        negativeButton(android.R.string.cancel) { dismiss() }
                    }
                }
            else
                register(composedAcquisition)
        }
    }

    private fun register(acquisition: Acquisition) {
        LauraApplication.database.acquisitionDao().add(acquisition).also { Wallet.main.balance -= acquisition.price }
        fragment.findNavController().popBackStack()
    }
}