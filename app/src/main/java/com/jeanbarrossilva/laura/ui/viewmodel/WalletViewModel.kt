package com.jeanbarrossilva.laura.ui.viewmodel

import android.text.InputType.TYPE_CLASS_NUMBER
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.ItemKeyProvider.SCOPE_MAPPED
import androidx.recyclerview.selection.SelectionPredicates.createSelectAnything
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.LauraApplication.Companion.acquirer
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.extension.AcquirerX.currentWallet
import com.jeanbarrossilva.laura.extension.BalanceInfluenceX.register
import com.jeanbarrossilva.laura.extension.FragmentX.reload
import com.jeanbarrossilva.laura.extension.WalletX.formattedBalance
import com.jeanbarrossilva.laura.ui.adapter.BalanceInfluenceAdapter
import com.jeanbarrossilva.laura.ui.detailslookup.AcquisitionDetailsLookup
import com.jeanbarrossilva.laura.ui.dialog.ScopedBottomSheetDialog
import com.jeanbarrossilva.laura.ui.fragment.WalletFragment
import com.jeanbarrossilva.laura.ui.fragment.WalletFragmentDirections
import com.jeanbarrossilva.laura.ui.keyprovider.BalanceInfluencenKeyProvider
import com.jeanbarrossilva.laura.ui.manager.LauraLinearLayoutManager
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence
import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogItem.AddQuantityItem
import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogScope.WalletModifierScope
import com.jeanbarrossilva.laurafoundation.implementation.FabConfigurator

class WalletViewModel(private val fragment: WalletFragment) : ViewModel(), FabConfigurator<WalletViewModel> {
    internal lateinit var acquisitionTracker: SelectionTracker<Long>

    override fun configFab(view: ImageButton) {
        with(view) {
            setOnClickListener { fragment.findNavController().navigate(R.id.action_walletFragment_to_acquisitionComposerFragment) }
            (this as FloatingActionButton).show()
        }
    }

    fun showInfoIn(titleView: TextView, balanceView: TextView) {
        with(acquirer.currentWallet) {
            titleView.text = name
            balanceView.text = formattedBalance
        }
    }

    fun loadAcquisitionsIn(view: RecyclerView) {
        view.adapter = BalanceInfluenceAdapter { influence ->
            val destination = WalletFragmentDirections.actionWalletFragmentToBalanceInfluenceFragment(influence)
            fragment.findNavController().navigate(destination)
        }

        view.layoutManager = LauraLinearLayoutManager(view.context)

        LauraApplication.balanceInfluences.observe(fragment) {
            it.reversed().let { influences ->
                (view.adapter as? BalanceInfluenceAdapter)?.influences = influences

                SelectionTracker
                    .Builder(
                        "BalanceInfluenceSelection",
                        view,
                        BalanceInfluencenKeyProvider(influences, SCOPE_MAPPED),
                        AcquisitionDetailsLookup(view),
                        StorageStrategy.createLongStorage()
                    )
                    .withSelectionPredicate(createSelectAnything())
                    .build()
                    .let { selectionTracker ->
                        acquisitionTracker = selectionTracker
                        (view.adapter as? BalanceInfluenceAdapter)?.tracker = selectionTracker
                    }
            }
        }
    }

    fun showWalletModifier(button: Button) {
        val dialog = ScopedBottomSheetDialog(button.context, WalletModifierScope) { selectedItem ->
            if (selectedItem is AddQuantityItem)
                MaterialDialog(button.context).show {
                    title(R.string.WalletModifier_item_add_quantity)
                    message(text = context.getString(R.string.WalletModifier_dialog_message_add_quantity).format(acquirer.currentWallet.name))

                    input(hintRes = R.string.WalletModifier_dialog_hint_add_quantity, inputType = TYPE_CLASS_NUMBER) { _, inserted ->
                        val riseName = context.getString(R.string.BalanceInfluence_title_rise)

                        inserted.toString().toFloat().let { quantity ->
                            BalanceInfluence.Rise(walletId = acquirer.currentWallet.id, name = riseName, amount = quantity).register()
                        }
                    }

                    positiveButton(android.R.string.ok) {
                        fragment.reload()
                        dismiss()
                    }

                    negativeButton(android.R.string.cancel) { dismiss() }
                }
        }

        button.setOnClickListener { dialog.show() }
    }
}