package com.jeanbarrossilva.lauradata.extension

import android.content.Context
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.R
import com.jeanbarrossilva.lauradata.extension.LocalDateTimeX.formattedExternally
import com.jeanbarrossilva.lauradata.extension.NumberX.currencyFormat

object BalanceInfluenceX {
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