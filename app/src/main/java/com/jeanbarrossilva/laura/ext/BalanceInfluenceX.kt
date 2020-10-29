package com.jeanbarrossilva.laura.ext

import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence

object BalanceInfluenceX {
    val BalanceInfluence.wallet get() = LauraApplication.wallets.value?.find { it.uuid == walletId }
}