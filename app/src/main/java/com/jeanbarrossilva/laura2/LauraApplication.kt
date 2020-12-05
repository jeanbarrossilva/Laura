package com.jeanbarrossilva.laura2

import android.app.Application
import com.jeanbarrossilva.lauradata.Acquirer
import com.jeanbarrossilva.lauradata.default.ObjectBox

class LauraApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)

        acquirer = Acquirer(context = this)
    }

    companion object {
        lateinit var acquirer: Acquirer
            private set
    }
}