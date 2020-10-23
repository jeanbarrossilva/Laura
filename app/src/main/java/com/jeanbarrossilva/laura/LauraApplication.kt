package com.jeanbarrossilva.laura

import android.app.Application
import androidx.lifecycle.LiveData
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laurafoundation.data.Wallet
import com.jeanbarrossilva.laurafoundation.data.base.LauraDatabase
import com.jeanbarrossilva.laurafoundation.ext.RoomDatabaseX.from

class LauraApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        database = LauraDatabase::class.from(this)
        wallets = database.walletDao().all()
        acquisitions = database.acquisitionDao().all()
    }

    companion object {
        lateinit var database: LauraDatabase
            private set

        lateinit var wallets: LiveData<List<Wallet>>
            private set

        lateinit var acquisitions: LiveData<List<Acquisition>>
            private set
    }
}