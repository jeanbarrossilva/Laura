package com.jeanbarrossilva.laura.ext

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.data.Acquirer
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence.Acquisition
import com.jeanbarrossilva.laurafoundation.data.Wallet

object AcquisitionX {
    private fun Acquisition.register(fragment: Fragment? = null) {
        LauraApplication.database.balanceInfluenceDao().add(this).also { Acquirer.currentWallet.balance -= amount }
        fragment?.findNavController()?.popBackStack()
    }

    fun Acquisition.registerOrWarnIfExpensiveFor(wallet: Wallet = Acquirer.currentWallet, fragment: Fragment? = null) {
        if (this isExpensiveFor wallet || this isInsaneFor wallet) {
            val message = when {
                this isExpensiveFor wallet -> R.string.dialog_message_expensive_acquisition
                this isInsaneFor wallet -> R.string.dialog_message_very_expensive_acquisition
                else -> 0
            }

            fragment?.context?.let {
                MaterialDialog(it).show {
                    title(text = it.getString(R.string.dialog_title_expensive_acquisition).format(wallet.name))
                    message(message)

                    positiveButton(android.R.string.ok) { register(fragment) }
                    negativeButton(android.R.string.cancel) { dismiss() }
                }
            }
        } else
            register(fragment)
    }
}