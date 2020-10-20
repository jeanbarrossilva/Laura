package com.jeanbarrossilva.laura.ext

import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import com.jeanbarrossilva.laura.R

object ContextX {
    val Context.isDark get() = resources.configuration.uiMode and UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES
    val Context.primaryColor get() = getColor(R.color.colorPrimary)
}