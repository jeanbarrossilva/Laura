package com.jeanbarrossilva.laura.ext

import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.TypedValue
import com.jeanbarrossilva.laura.R

object ContextX {
    val Context.colorAttr get() = { attr: Int ->
        TypedValue().apply { theme.resolveAttribute(attr, this, true) }.resourceId.let { color -> getColor(color) }
    }

    val Context.primaryColor get() = getColor(R.color.colorPrimary)
}