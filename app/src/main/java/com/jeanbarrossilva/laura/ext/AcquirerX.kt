package com.jeanbarrossilva.laura.ext

import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laurafoundation.data.Acquirer

object AcquirerX {
    var Acquirer.currentWallet
        get() = LauraApplication.database.walletDao().identifiedAs(currentWalletId)
        set(value) {
            currentWalletId = value.id
        }
}