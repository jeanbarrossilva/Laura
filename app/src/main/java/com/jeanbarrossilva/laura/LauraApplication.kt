package com.jeanbarrossilva.laura

import android.app.Application
import com.jeanbarrossilva.laurafoundation.data.base.AcquisitionDatabase
import com.jeanbarrossilva.laurafoundation.ext.RoomDatabaseX.from

class LauraApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        acquisitionDatabase = AcquisitionDatabase::class.from(this)
    }

    companion object {
        lateinit var acquisitionDatabase: AcquisitionDatabase
            private set
    }
}