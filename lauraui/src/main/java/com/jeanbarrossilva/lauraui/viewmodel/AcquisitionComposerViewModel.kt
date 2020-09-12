package com.jeanbarrossilva.lauraui.viewmodel

import android.view.WindowInsets.Type.ime
import android.widget.Button
import android.widget.EditText
import androidx.annotation.IdRes
import androidx.core.view.doOnLayout
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.laurafoundation.Acquisition
import com.jeanbarrossilva.lauraui.component.CurrencyAmountView
import com.jeanbarrossilva.lauraui.fragment.AcquisitionComposerFragment

class AcquisitionComposerViewModel(private val fragment: AcquisitionComposerFragment, @IdRes private val nameFieldRes: Int) : ViewModel() {
    private val nameField = fragment.view?.findViewById<EditText>(nameFieldRes)
    private val name = nameField?.text?.toString() ?: ""

    init {
        nameField?.requestFocus()
        fragment.view?.doOnLayout { it.windowInsetsController?.show(ime()) }
    }

    fun compose(button: Button?, currencyAmountView: CurrencyAmountView) {
        button?.setOnClickListener {
            val composed = Acquisition(name = name, currency = currencyAmountView.currency, value = currencyAmountView.getAmount() ?: 0)
            fragment.view?.windowInsetsController?.hide(ime())
        }
    }
}