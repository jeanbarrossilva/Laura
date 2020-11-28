package com.jeanbarrossilva.laura2.extension

import android.content.Context
import com.jeanbarrossilva.laura2.extension.BalanceInfluenceX.wallet
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.extension.NumberX.percentOf

object AcquisitionX {
    val BalanceInfluence.Acquisition.isExpensive get() = amount > 50 percentOf wallet.balance

    fun BalanceInfluence.Acquisition.warn(context: Context, onConfirm: () -> Unit) {
        TODO()
    }
}