package com.jeanbarrossilva.laura.ext

import android.view.Menu
import android.view.MenuItem
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