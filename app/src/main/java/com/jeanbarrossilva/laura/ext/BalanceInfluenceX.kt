package com.jeanbarrossilva.laura.ext

import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laurafoundation.data.Acquirer
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence

object BalanceInfluenceX {
    val BalanceInfluence.wallet get() = LauraApplication.database.walletDao().identifiedAs(walletId)

    fun BalanceInfluence.register() {
        LauraApplication.database.balanceInfluenceDao().add(this)
        with(Acquirer.currentWallet) { if (decreases) balance -= amount else balance += amount }
    }
}