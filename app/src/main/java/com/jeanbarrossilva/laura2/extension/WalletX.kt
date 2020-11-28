package com.jeanbarrossilva.laura2.extension

import com.jeanbarrossilva.laura2.LauraApplication
import com.jeanbarrossilva.lauradata.Wallet

object WalletX {
    fun Wallet.update(block: Wallet.() -> Unit) {
        block(this)
        LauraApplication.database.walletDao().update(this)
    }
}