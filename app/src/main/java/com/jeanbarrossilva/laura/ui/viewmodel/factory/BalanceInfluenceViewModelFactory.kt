package com.jeanbarrossilva.laura.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbarrossilva.laura.ui.fragment.BalanceInfluenceFragment

class BalanceInfluenceViewModelFactory(private val fragment: BalanceInfluenceFragment) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(BalanceInfluenceFragment::class.java).newInstance(fragment)
}