package com.jeanbarrossilva.laura.extension

import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.data.Wallet
import com.jeanbarrossilva.laura.extension.NumberX.currencyFormat

object WalletX {
    val Wallet.formattedBalance get() = "${currency.symbol} ${currencyFormat.format(balance)}"

    fun Wallet.update(block: Wallet.() -> Unit) {
        block(this)
        LauraApplication.database.walletDao().update(this)
    }
}