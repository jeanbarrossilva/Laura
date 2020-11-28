package com.jeanbarrossilva.lauradata.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.jeanbarrossilva.lauradata.extension.ContextX.preferences

object AppCompatActivityX {
    private const val PREFERENCE_KEY_IS_FIRST_LAUNCH = "isFirstLaunch"

    fun AppCompatActivity.onFirstLaunch(block: () -> Unit) {
        preferences.getBoolean(PREFERENCE_KEY_IS_FIRST_LAUNCH, true).let { isFirstLaunch ->
            if (isFirstLaunch) {
                block()
                preferences.edit { putBoolean(PREFERENCE_KEY_IS_FIRST_LAUNCH, false) }
            }
        }
    }
}