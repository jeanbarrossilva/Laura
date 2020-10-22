package com.jeanbarrossilva.lauracore

import com.jeanbarrossilva.laurafoundation.data.Wallet

class WalletModel {
    private val wallets = mutableListOf<Wallet>()

    fun getWallets() = wallets

    init {
        if (Wallet.main !in wallets) wallets.add(Wallet.main)
    }
}