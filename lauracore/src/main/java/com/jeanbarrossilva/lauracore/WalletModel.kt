package com.jeanbarrossilva.lauracore

import com.jeanbarrossilva.laurafoundation.data.Wallet
import java.util.Currency
import java.util.Locale

class WalletModel {
    private val wallets = mutableListOf<Wallet>()
    val mainWallet = Wallet(name = "Wallet", currency = Locale.getDefault().let { Currency.getInstance(it) }, balance = 0.0)

    fun getWallets() = wallets

    init {
        if (mainWallet !in wallets) wallets.add(mainWallet)
    }
}