package com.jeanbarrossilva.lauraui.root

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jeanbarrossilva.lauraui.viewmodel.AcquisitionComposerViewModel
import com.jeanbarrossilva.lauraui.viewmodel.factory.AcquisitionComposerViewModelFactory
import com.jeanbarrossilva.lauraui.R
import kotlinx.android.synthetic.main.fragment_acquisition_composer.*

class AcquisitionComposerFragment : Fragment(R.layout.fragment_acquisition_composer) {
    private val viewModel by viewModels<AcquisitionComposerViewModel> { AcquisitionComposerViewModelFactory(this, R.id.name) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.compose(null, currency_amount)
    }
}