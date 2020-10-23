package com.jeanbarrossilva.laura.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ui.viewmodel.OnboardingViewModel
import com.jeanbarrossilva.laura.ui.viewmodel.factory.OnboardingViewModelFactory
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {
    private val viewModel by viewModels<OnboardingViewModel> { OnboardingViewModelFactory(fragment = this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.highlightIndicatorOf(indicator_layout)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.showFragments()
    }
}