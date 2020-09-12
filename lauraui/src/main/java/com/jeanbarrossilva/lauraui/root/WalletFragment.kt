package com.jeanbarrossilva.lauraui.root

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jeanbarrossilva.lauraui.R
import com.jeanbarrossilva.lauraui.viewmodel.WalletViewModel
import com.jeanbarrossilva.lauraui.viewmodel.factory.WalletViewModelFactory
import kotlinx.android.synthetic.main.fragment_wallet.*
import kotlinx.android.synthetic.main.fragment_wallet.currency_symbol

class WalletFragment : Fragment(R.layout.fragment_wallet) {
    private val viewModel by viewModels<WalletViewModel> { WalletViewModelFactory(this, R.id.fab) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            setupFab()
            showBalance(currency_symbol, balance)
        }
    }
}