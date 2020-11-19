package com.jeanbarrossilva.laura

import android.app.Application
import androidx.lifecycle.LiveData
import com.jeanbarrossilva.laura.data.Acquirer
import com.jeanbarrossilva.laura.data.BalanceInfluence
import com.jeanbarrossilva.laura.data.Wallet
import com.jeanbarrossilva.laura.data.base.LauraDatabase
import com.jeanbarrossilva.laura.extension.RoomDatabaseX.from

class LauraApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        database = LauraDatabase::class.from(this)
        wallets = database.walletDao().all()
        balanceInfluences = database.balanceInfluenceDao().all()

        acquirer = Acquirer(context = this)
    }

    companion object {
        lateinit var database: LauraDatabase
            private set

        lateinit var wallets: LiveData<List<Wallet>>
            private set

        lateinit var balanceInfluences: LiveData<List<BalanceInfluence>>

        lateinit var acquirer: Acquirer
            private set
    }
}