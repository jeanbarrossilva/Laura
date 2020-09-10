package com.jeanbarrossilva.laura.core

import android.widget.TextView
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.laura.BillApp.Companion.app
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ui.WalletFragment
import com.jeanbarrossilva.laura.foundation.Acquisition

class WalletViewModel(private val fragment: WalletFragment, @IdRes private val fabId: Int) : ViewModel() {
    private val model = WalletModel(fragment.context)
    private val acquisitions = mutableListOf<Acquisition>()

    fun setupFab() {
        val fab = fragment.view?.findViewById<FloatingActionButton>(fabId)
        fab?.setOnClickListener { fragment.findNavController().navigate(R.id.action_walletFragment_to_acquisitionComposerFragment) }
    }

    fun showBalance(currencySymbolView: TextView, valueView: TextView) {
        currencySymbolView.text = model.balance.currency?.symbol
        valueView.text = app.decimalFormat.apply { minimumFractionDigits = 2 }.format(model.balance.number)
    }

    fun addAcquisition(acquisition: Acquisition) {
        acquisitions.add(acquisition)
    }
}