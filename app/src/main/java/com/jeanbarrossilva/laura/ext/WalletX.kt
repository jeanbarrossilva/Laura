package com.jeanbarrossilva.laura.ext

import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laurafoundation.LauraFoundation
import com.jeanbarrossilva.laurafoundation.data.Wallet

object WalletX {
    val Wallet.formattedBalance get() = "${currency.symbol} ${LauraFoundation.currencyFormat.format(balance)}"

    fun Wallet.update(block: Wallet.() -> Unit) {
        block(this)
        LauraApplication.database.walletDao().update(this)
    }
}