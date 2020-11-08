package com.jeanbarrossilva.laurafoundation.ext

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.inputmethod.InputMethodManager
import androidx.annotation.StyleableRes

object ContextX {
    internal val Context.inputMethodManager get() = getSystemService(InputMethodManager::class.java)

    val Context.colorAttr get() = { attr: Int ->
        TypedValue().apply { theme.resolveAttribute(attr, this, true) }.resourceId.let { color -> getColor(color) }
    }

    fun Context.obtainStyledAttrs(
        @StyleableRes styleable: IntArray,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        onEachIndex: TypedArray.(Int) -> Unit
    ) {
        theme.obtainStyledAttributes(attrs, styleable, defStyleAttr, 0).run {
            for (index in 0 until indexCount) onEachIndex(this, index)
            recycle()
        }
    }
}