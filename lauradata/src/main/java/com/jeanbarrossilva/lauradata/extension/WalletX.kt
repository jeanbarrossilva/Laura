package com.jeanbarrossilva.lauradata.extension

import com.jeanbarrossilva.lauradata.Wallet
import com.jeanbarrossilva.lauradata.extension.NumberX.currencyFormat

object WalletX {
    val Wallet.formattedBalance get() = "${currency.symbol} ${currencyFormat.format(balance)}"
}