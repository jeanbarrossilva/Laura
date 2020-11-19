package com.jeanbarrossilva.laura

import android.app.Application
import androidx.lifecycle.LiveData
import com.jeanbarrossilva.laura.extension.ContextX.colorAttr
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

        primaryColor = getColor(R.color.colorPrimary)
        primaryTextColor = colorAttr(android.R.attr.textColorPrimary)
        inversePrimaryTextColor = colorAttr(android.R.attr.textColorPrimaryInverse)
        tertiaryTextColor = colorAttr(android.R.attr.textColorTertiary)
        selectedBalanceInfluenceBackgroundColor = getColor(R.color.selectedBalanceInfluenceBackground)
        balanceInfluenceIconBackgroundColor = getColor(R.color.balanceInfluenceIconBackground)
        selectedBalanceInfluenceIconBackgroundColor = getColor(R.color.selectedBalanceInfluenceIconBackground)
    }

    companion object {
        lateinit var database: LauraDatabase
            private set

        lateinit var wallets: LiveData<List<Wallet>>
            private set

        lateinit var balanceInfluences: LiveData<List<BalanceInfluence>>

        lateinit var acquirer: Acquirer
            private set

        var primaryColor: Int = 0
            private set

        var primaryTextColor: Int = 0
            private set

        var inversePrimaryTextColor: Int = 0
            private set

        var tertiaryTextColor: Int = 0
            private set

        var selectedBalanceInfluenceBackgroundColor: Int = 0
            private set

        var balanceInfluenceIconBackgroundColor: Int = 0
            private set

        var selectedBalanceInfluenceIconBackgroundColor: Int = 0
            private set
    }
}