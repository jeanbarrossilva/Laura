package com.jeanbarrossilva.laurafoundation.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit

object Acquirer {
    private val preferences = { context: Context -> context.getSharedPreferences("acquirer", MODE_PRIVATE) }

    var salary = 0f
        private set

    var currentWallet = Wallet.main
        private set

    fun setSalary(context: Context, value: Float) {
        salary = value
        preferences(context).edit { putFloat("salary", salary) }
    }

    fun setCurrentWallet(context: Context, wallet: Wallet) {
        currentWallet = wallet
        preferences(context).edit { putLong("currentWallet", currentWallet.id) }
    }
}