package com.jeanbarrossilva.lauraui.kit

import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbarrossilva.lauraui.AcquisitionComposerFragment

class AcquisitionComposerViewModelFactory(private val fragment: AcquisitionComposerFragment, @IdRes private val nameFieldRes: Int)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(AcquisitionComposerFragment::class.java, Int::class.java).newInstance(fragment, nameFieldRes)
}