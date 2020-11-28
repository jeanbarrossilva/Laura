package com.jeanbarrossilva.laura2

import android.app.Application
import com.jeanbarrossilva.lauradata.Acquirer
import com.jeanbarrossilva.lauradata.base.LauraDatabase
import com.jeanbarrossilva.lauradata.extension.RoomDatabaseX.from

class LauraApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        database = LauraDatabase::class.from(this)
        acquirer = Acquirer(context = this)
    }

    companion object {
        lateinit var database: LauraDatabase
            private set

        lateinit var acquirer: Acquirer
            private set
    }
}