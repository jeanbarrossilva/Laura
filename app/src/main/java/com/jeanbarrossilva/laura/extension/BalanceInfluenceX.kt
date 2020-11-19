package com.jeanbarrossilva.laura.extension

import android.content.Context
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.extension.WalletX.update
import com.jeanbarrossilva.laura.data.BalanceInfluence
import com.jeanbarrossilva.laura.extension.LocalDateTimeX.formattedExternally
import com.jeanbarrossilva.laura.extension.NumberX.currencyFormat

object BalanceInfluenceX {
    private val dao = LauraApplication.database.balanceInfluenceDao()

    val BalanceInfluence.formattedAmount get() = "${wallet.currency.symbol} ${currencyFormat.format(amount)}"
    val BalanceInfluence.wallet get() = LauraApplication.database.walletDao().identifiedAs(walletId)

    fun BalanceInfluence.register() {
        dao.add(this)
        wallet.update { plus(this@register) }
    }

    fun BalanceInfluence.unregister() {
        dao.remove(this)
        wallet.update { minus(this@unregister) }
    }

    fun BalanceInfluence.update(block: BalanceInfluence.() -> Unit) {
        block(this)
        dao.update(this)
    }

    inline fun BalanceInfluence.withRegistrationDate(
        context: Context?,
        crossinline block: (standard: String, extended: String) -> Unit = { _, _ -> }
    ) {
        context?.let {
            val (standardRes, extendedRes) =
                R.string.BalanceInfluence_registration_date_standard to R.string.BalanceInfluence_registration_date_extended

            val (standardText, extendedText) = it.getString(standardRes) to it.getString(extendedRes)

            with(dateTime) { standardText.format(formattedExternally) to extendedText.format(formattedExternally, hour, minute) }
                .let { (standard, extended) -> block(standard, extended) }
        }
    }
}