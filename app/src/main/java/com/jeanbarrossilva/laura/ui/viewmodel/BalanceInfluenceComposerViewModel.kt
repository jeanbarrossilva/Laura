package com.jeanbarrossilva.laura.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.jeanbarrossilva.laura.LauraApplication.Companion.acquirer
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.ext.AcquirerX.currentWallet
import com.jeanbarrossilva.laura.ext.AcquisitionX.isExpensive
import com.jeanbarrossilva.laura.ext.AcquisitionX.registerAndPop
import com.jeanbarrossilva.laura.ext.AcquisitionX.warn
import com.jeanbarrossilva.laura.ext.TextInputEditTextX.required
import com.jeanbarrossilva.laura.ui.component.PriceFieldView
import com.jeanbarrossilva.laura.ui.fragment.BalanceInfluenceComposerFragment
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence.Acquisition
import kotlinx.android.synthetic.main.view_price_field.view.amountField

class BalanceInfluenceComposerViewModel(private val fragment: BalanceInfluenceComposerFragment) : ViewModel() {
    fun compose(nameField: TextInputEditText, priceField: PriceFieldView) {
        withFab {
            setOnClickListener {
                listOf(nameField, priceField.amountField).forEach { field ->
                    field.required { "This field is required." }
                }

                Acquisition(walletId = acquirer.currentWallet.id, name = nameField.text.toString(), amount = priceField.getAmount()!!)
                    .let { if (it.isExpensive) it.warn(context) { it.registerAndPop(fragment) } else it.registerAndPop(fragment) }
            }
        }
    }
}