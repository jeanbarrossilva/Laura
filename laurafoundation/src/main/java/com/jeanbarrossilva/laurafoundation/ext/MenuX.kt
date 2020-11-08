package com.jeanbarrossilva.laurafoundation.ext

import android.view.Menu
import androidx.annotation.StringRes
import androidx.core.view.children

object MenuX {
    fun Menu.addIfNotAdded(groupId: Int = 0, itemId: Int, order: Int, @StringRes titleRes: Int, onClick: () -> Unit) =
        if (!children.any { it.itemId == itemId })
            add(groupId, itemId, order, titleRes).setOnMenuItemClickListener {
                onClick()
                true
            }
        else
            null
}