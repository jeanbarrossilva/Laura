package com.jeanbarrossilva.laura.ui.viewmodel.factory

import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbarrossilva.laura.ui.WalletFragment

class WalletViewModelFactory(private val fragment: WalletFragment, @IdRes private val fabId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(WalletFragment::class.java, Int::class.java).newInstance(fragment, fabId)
}