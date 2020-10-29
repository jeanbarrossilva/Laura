package com.jeanbarrossilva.laura

import android.app.Application
import androidx.lifecycle.LiveData
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence
import com.jeanbarrossilva.laurafoundation.data.Wallet
import com.jeanbarrossilva.laurafoundation.data.base.LauraDatabase
import com.jeanbarrossilva.laurafoundation.data.dao.BalanceInfluenceDao
import com.jeanbarrossilva.laurafoundation.data.dao.WalletDao
import com.jeanbarrossilva.laurafoundation.ext.RoomDatabaseX.from

class LauraApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        database = LauraDatabase::class.from(this)
        wallets = database.walletDao().all()
        balanceInfluences = database.balanceInfluenceDao().all()
    }

    companion object {
        lateinit var database: LauraDatabase
            private set

        lateinit var wallets: LiveData<List<Wallet>>
            private set

        lateinit var balanceInfluences: LiveData<List<BalanceInfluence>>
    }
}