package com.jeanbarrossilva.lauradata

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit

class Acquirer(context: Context) {
    private val preferences = context.getSharedPreferences("acquirer", MODE_PRIVATE)

    var salary: Float
        get() = preferences.getFloat("salary", 0f)
        set(value) = preferences.edit { putFloat("salary", value) }

    var currentWalletId: Long
        get() = preferences.getLong("currentWallet", Wallet.main.id)
        set(value) = preferences.edit { putLong("currentWallet", value) }
}