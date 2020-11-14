package com.jeanbarrossilva.laura.ext

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ext.BalanceInfluenceX.register
import com.jeanbarrossilva.laura.ext.BalanceInfluenceX.wallet
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence.Acquisition
import com.jeanbarrossilva.laurafoundation.ext.NumberX.percentOf

object AcquisitionX {
    val Acquisition.isExpensive get() = amount > 50 percentOf wallet.balance

    fun Acquisition.registerAndPop(fragment: Fragment) {
        register()
        fragment.findNavController().popBackStack()
    }

    fun Acquisition.warn(context: Context, onConfirm: () -> Unit) {
        MaterialDialog(context).show {
            title(text = context.getString(R.string.BalanceInfluenceComposer_dialog_title_expensive_acquisition).format(wallet.name))
            message(text = context.getString(R.string.BalanceInfluenceComposer_dialog_message_expensive_acquisition).format(wallet.name))

            positiveButton(android.R.string.ok) { onConfirm() }
            negativeButton(android.R.string.cancel) { dismiss() }
        }
    }
}