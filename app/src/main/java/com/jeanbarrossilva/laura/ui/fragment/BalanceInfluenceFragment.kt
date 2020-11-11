package com.jeanbarrossilva.laura.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.ui.viewmodel.BalanceInfluenceViewModel
import com.jeanbarrossilva.laura.ui.viewmodel.factory.BalanceInfluenceViewModelFactory
import com.jeanbarrossilva.laurafoundation.`interface`.ComponentEditor
import com.jeanbarrossilva.laurafoundation.data.ComponentEditorState.*
import com.jeanbarrossilva.laurafoundation.ext.ComponentEditorX.observe
import kotlinx.android.synthetic.main.fragment_balance_influence.*

class BalanceInfluenceFragment : Fragment(R.layout.fragment_balance_influence), ComponentEditor {
    override val lifecycleOwner = this

    private val viewModel by viewModels<BalanceInfluenceViewModel> { BalanceInfluenceViewModelFactory(fragment = this) }

    internal val navArgs by navArgs<BalanceInfluenceFragmentArgs>()

    override fun onResume() {
        super.onResume()

        withFab {
            observe({ state() }) { setImageResource(if (it is EditingState) R.drawable.ic_check else R.drawable.ic_edit) }
            setOnClickListener { switchState() }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            showInfoIn(iconView, titleView, registrationDateView)
            configTableLayout(tableLayout)
        }
    }
}