package com.jeanbarrossilva.laura.ui.viewmodel.factory

import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbarrossilva.laura.ui.OnboardingFragment

class OnboardingViewModelFactory(private val fragment: OnboardingFragment, @IdRes private val pagerId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(OnboardingFragment::class.java, Int::class.java).newInstance(fragment, pagerId)
}