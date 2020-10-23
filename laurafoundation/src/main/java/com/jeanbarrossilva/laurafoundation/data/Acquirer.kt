package com.jeanbarrossilva.laurafoundation.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit

object Acquirer {
    private val preferences = { context: Context -> context.getSharedPreferences("acquirer", MODE_PRIVATE) }

    var salary = 0f
        private set

    fun setSalary(context: Context, value: Float) {
        salary = value
        preferences(context).edit { putFloat("salary", value) }
    }
}