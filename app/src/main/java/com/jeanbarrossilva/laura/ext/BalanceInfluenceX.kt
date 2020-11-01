package com.jeanbarrossilva.laura.ext

import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.ext.WalletX.update
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence

object BalanceInfluenceX {
    val BalanceInfluence.wallet get() = LauraApplication.database.walletDao().identifiedAs(walletId)

    fun BalanceInfluence.register() {
        LauraApplication.database.balanceInfluenceDao().add(this)
        wallet.update { plus(this@register) }
    }

    fun BalanceInfluence.unregister() {
        LauraApplication.database.balanceInfluenceDao().remove(this)
        wallet.update { minus(this@unregister) }
    }
}