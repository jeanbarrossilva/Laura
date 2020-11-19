package com.jeanbarrossilva.laura.extension

import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.data.Acquirer

object AcquirerX {
    var Acquirer.currentWallet
        get() = LauraApplication.database.walletDao().identifiedAs(currentWalletId)
        set(value) {
            currentWalletId = value.id
        }
}