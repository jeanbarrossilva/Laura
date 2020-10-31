package com.jeanbarrossilva.laura.ext

import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.LauraApplication.Companion.acquirer
import com.jeanbarrossilva.laura.ext.AcquirerX.currentWallet
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence

object BalanceInfluenceX {
    val BalanceInfluence.wallet get() = LauraApplication.database.walletDao().identifiedAs(walletId)

    fun BalanceInfluence.register() {
        LauraApplication.database.balanceInfluenceDao().add(this)

        with(acquirer.currentWallet) {
            if (decreases) balance -= amount else balance += amount
            LauraApplication.database.walletDao().update(this)
        }
    }
}