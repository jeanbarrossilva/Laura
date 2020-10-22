package com.jeanbarrossilva.laura.ui.viewmodel

import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ext.LiveDataX.observeFrom
import com.jeanbarrossilva.laura.ui.adapter.AcquisitionAdapter
import com.jeanbarrossilva.laura.ui.dialog.ScopedBottomSheetDialog
import com.jeanbarrossilva.laura.ui.fragment.WalletFragment
import com.jeanbarrossilva.lauracore.WalletModel
import com.jeanbarrossilva.laurafoundation.LauraFoundation
import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogScope.WalletModifierScope
import com.jeanbarrossilva.laurafoundation.data.Wallet

class WalletViewModel(private val fragment: WalletFragment) : ViewModel() {
    @Suppress("Unused")
    private val model = WalletModel()

    private val acquisitions = LauraApplication.acquisitionDatabase.dao().all()

    @Suppress("SetTextI18n")
    fun showInfoIn(walletTitleView: TextView, balanceView: TextView) {
        Wallet.main.name.observe(fragment) { walletTitleView.text = it }

        listOf(Wallet.main.currency, Wallet.main.balance).observeFrom(fragment) {
            balanceView.text = "${Wallet.main.currency.value?.symbol} ${LauraFoundation.currencyFormat.format(Wallet.main.balance.value)}"
        }
    }

    fun loadAcquisitionsIn(view: RecyclerView) {
        view.layoutManager = LinearLayoutManager(view.context)
        acquisitions.observe(fragment) { view.adapter = AcquisitionAdapter(acquisitions = it) }
    }

    fun showWalletModifier(button: Button) {
        val dialog = ScopedBottomSheetDialog(button.context, WalletModifierScope) { selectedItem -> TODO("Action for $selectedItem.") }
        button.setOnClickListener { dialog.show() }
    }

    init {
        withFab {
            setOnClickListener { fragment.findNavController().navigate(R.id.action_walletFragment_to_acquisitionComposerFragment) }
        }
    }
}