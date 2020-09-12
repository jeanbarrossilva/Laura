package com.jeanbarrossilva.lauraui.viewmodel

import android.widget.TextView
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.lauracore.WalletModel
import com.jeanbarrossilva.laurafoundation.Acquisition
import com.jeanbarrossilva.lauraui.R
import com.jeanbarrossilva.lauraui.fragment.WalletFragment
import java.text.DecimalFormat

class WalletViewModel(private val fragment: WalletFragment, @IdRes private val fabId: Int) : ViewModel() {
    private val model = WalletModel(fragment.context)
    private val acquisitions = mutableListOf<Acquisition>()

    fun setupFab() {
        val fab = fragment.view?.findViewById<FloatingActionButton>(fabId)
        fab?.setOnClickListener { fragment.findNavController().navigate(R.id.action_walletFragment_to_acquisitionComposerFragment) }
    }

    fun showBalance(currencySymbolView: TextView, valueView: TextView) {
        currencySymbolView.text = model.balance.currency?.symbol
        valueView.text = DecimalFormat.getInstance().apply { minimumFractionDigits = 2 }.format(model.balance.number)
    }

    fun addAcquisition(acquisition: Acquisition) {
        acquisitions.add(acquisition)
    }
}