package com.jeanbarrossilva.laura2.extension

import com.jeanbarrossilva.laura2.LauraApplication
import com.jeanbarrossilva.laura2.extension.WalletX.update
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.extension.NumberX.currencyFormat

object BalanceInfluenceX {
    private val dao = LauraApplication.database.balanceInfluenceDao()

    val BalanceInfluence.formattedAmount get() = "${wallet.currency.symbol} ${currencyFormat.format(amount)}"
    val BalanceInfluence.wallet get() = LauraApplication.database.walletDao().identifiedAs(walletId)

    fun BalanceInfluence.register() {
        dao.add(this)
        wallet.update { plus(this@register) }
    }

    fun BalanceInfluence.unregister() {
        dao.remove(this)
        wallet.update { minus(this@unregister) }
    }
}