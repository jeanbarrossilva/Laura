package com.jeanbarrossilva.laura2.extension

import com.jeanbarrossilva.laura2.LauraApplication
import com.jeanbarrossilva.lauradata.Acquirer

object AcquirerX {
    var Acquirer.currentWallet
        get() = LauraApplication.database.walletDao().identifiedAs(currentWalletId)
        set(value) {
            currentWalletId = value.id
        }
}