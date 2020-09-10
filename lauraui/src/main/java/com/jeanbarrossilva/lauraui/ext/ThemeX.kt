package com.jeanbarrossilva.lauraui.ext

import android.content.res.Resources.Theme
import android.util.TypedValue
import com.jeanbarrossilva.lauraui.R

object ThemeX {
    internal val Theme.attr get() = { id: Int ->
        TypedValue().apply { resolveAttribute(id, this, true) }
    }

    val Theme.primaryColor get() = attr(R.attr.colorPrimary).data
}