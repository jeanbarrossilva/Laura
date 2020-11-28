package com.jeanbarrossilva.lauradata.implementation

import android.widget.ImageButton
import androidx.lifecycle.ViewModel

interface FabConfigurator<out T : ViewModel> {
    fun configFab(view: ImageButton)
}