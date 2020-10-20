package com.jeanbarrossilva.laura.ui.viewmodel

import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ui.dialog.ScopedBottomSheetDialog
import com.jeanbarrossilva.laura.ui.fragment.WalletFragment
import com.jeanbarrossilva.lauracore.WalletModel
import com.jeanbarrossilva.laurafoundation.LauraFoundation
import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogScope.WalletModifierScope

class WalletViewModel(private val fragment: WalletFragment) : ViewModel() {
    private val model = WalletModel()
    private val mainWallet = model.mainWallet

    @Suppress("SetTextI18n")
    fun showInfoIn(walletTitleView: TextView, balanceView: TextView) {
        walletTitleView.text = mainWallet.name
        balanceView.text = "${mainWallet.currency.symbol} ${LauraFoundation.currencyFormat.format(mainWallet.balance)}"
    }

    fun showWalletModifier(button: Button) {
        val dialog = ScopedBottomSheetDialog(button.context, WalletModifierScope) { selectedItem -> println("Selected item: $selectedItem.") }
        button.setOnClickListener { dialog.show() }
    }

    init {
        withFab {
            setOnClickListener { fragment.findNavController().navigate(R.id.action_walletFragment_to_acquisitionComposerFragment) }
        }
    }
}