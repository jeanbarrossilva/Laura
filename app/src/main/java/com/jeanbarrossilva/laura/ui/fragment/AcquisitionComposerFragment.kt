package com.jeanbarrossilva.laura.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.ui.viewmodel.AcquisitionComposerViewModel
import com.jeanbarrossilva.laura.ui.viewmodel.factory.AcquisitionComposerViewModelFactory

class AcquisitionComposerFragment : Fragment(R.layout.fragment_acquisition_composer) {
    private val viewModel by viewModels<AcquisitionComposerViewModel> { AcquisitionComposerViewModelFactory(this) }

    override fun onResume() {
        super.onResume()
        withFab(R.drawable.ic_check)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.compose()
    }
}