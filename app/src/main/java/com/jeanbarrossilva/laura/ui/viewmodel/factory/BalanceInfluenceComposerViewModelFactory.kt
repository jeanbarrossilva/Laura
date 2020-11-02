package com.jeanbarrossilva.laura.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbarrossilva.laura.ui.fragment.BalanceInfluenceComposerFragment

class BalanceInfluenceComposerViewModelFactory(private val fragment: BalanceInfluenceComposerFragment)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(BalanceInfluenceComposerFragment::class.java).newInstance(fragment)
}