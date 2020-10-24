package com.jeanbarrossilva.laura.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
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
            setOnClickListener {
                listOf(fragment.nameField, fragment.priceField?.amountField).forEach { field ->
                    field?.required { "This field is required." }
                }

                val composedAcquisition = Acquisition(
                    name = fragment.nameField.text.toString(),
                    currency = fragment.priceField.currency,
                    price = fragment.priceField.amountField.text.toString().toFloatOrNull()!!
                )

                if (composedAcquisition isExpensiveFor Acquirer.currentWallet)
                    fragment.context?.let {
                        MaterialDialog(it).show {
                            title(text = "Too expensive!")
                            message(text = "This acquisition will let your ${Acquirer.currentWallet.name} wallet with a negative balance. Are " +
                                    "you sure you want to register?")

                            positiveButton(android.R.string.ok) { register(composedAcquisition) }
                            negativeButton(android.R.string.cancel) { dismiss() }
                        }
                    }
                else
                    register(composedAcquisition)
            }
        }
    }

    private fun register(acquisition: Acquisition) {
        LauraApplication.database.acquisitionDao().add(acquisition).also { Acquirer.currentWallet.balance -= acquisition.price }
        fragment.findNavController().popBackStack()
    }
}