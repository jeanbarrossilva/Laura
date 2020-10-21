package com.jeanbarrossilva.laura.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ui.viewmodel.WalletViewModel
import com.jeanbarrossilva.laura.ui.viewmodel.factory.WalletViewModelFactory
import kotlinx.android.synthetic.main.fragment_wallet.*

class WalletFragment : Fragment(R.layout.fragment_wallet) {
    private val viewModel by viewModels<WalletViewModel> { WalletViewModelFactory(this) }

    override fun onResume() {
        super.onResume()
        withFab { show() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            showInfoIn(titleView, balanceView)
            loadAcquisitionsIn(acquisitionsView)
            showWalletModifier(modifyWalletButton)
        }
    }
}