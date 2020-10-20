package com.jeanbarrossilva.laura.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbarrossilva.laura.ui.fragment.AcquisitionComposerFragment

class AcquisitionComposerViewModelFactory(private val fragment: AcquisitionComposerFragment)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(AcquisitionComposerFragment::class.java).newInstance(fragment)
}