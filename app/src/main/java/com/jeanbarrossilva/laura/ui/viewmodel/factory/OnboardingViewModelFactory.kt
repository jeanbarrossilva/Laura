package com.jeanbarrossilva.laura.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbarrossilva.laura.ui.fragment.OnboardingFragment

class OnboardingViewModelFactory(private val fragment: OnboardingFragment) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(OnboardingFragment::class.java).newInstance(fragment)
}