package com.jeanbarrossilva.laura.ext

import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laurafoundation.data.Wallet

object WalletX {
    fun Wallet.update(block: Wallet.() -> Unit) {
        block(this)
        LauraApplication.database.walletDao().update(this)
    }
}