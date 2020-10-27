package com.jeanbarrossilva.laura.ui.viewmodel

import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.ItemKeyProvider.SCOPE_MAPPED
import androidx.recyclerview.selection.SelectionPredicates.createSelectAnything
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.activities.MainActivity.Companion.withFab
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ui.adapter.AcquisitionAdapter
import com.jeanbarrossilva.laura.ui.detailslookup.AcquisitionDetailsLookup
import com.jeanbarrossilva.laura.ui.dialog.ScopedBottomSheetDialog
import com.jeanbarrossilva.laura.ui.fragment.WalletFragment
import com.jeanbarrossilva.laura.ui.keyprovider.AcquisitionKeyProvider
import com.jeanbarrossilva.laura.ui.manager.LauraLinearLayoutManager
import com.jeanbarrossilva.laurafoundation.LauraFoundation
import com.jeanbarrossilva.laurafoundation.data.Acquirer
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogScope.WalletModifierScope

class WalletViewModel(private val fragment: WalletFragment) : ViewModel() {
    private val acquisitions = LauraApplication.database.acquisitionDao().all()
    internal lateinit var acquisitionTracker: SelectionTracker<Acquisition>

    @Suppress("SetTextI18n")
    fun showInfoIn(walletTitleView: TextView, balanceView: TextView) {
        walletTitleView.text = Acquirer.currentWallet.name
        balanceView.text = "${Acquirer.currentWallet.currency.symbol} ${LauraFoundation.currencyFormat.format(Acquirer.currentWallet.balance)}"
    }

    fun loadAcquisitionsIn(view: RecyclerView) {
        view.layoutManager = LauraLinearLayoutManager(view.context)

        acquisitions.observe(fragment) {
            view.adapter = AcquisitionAdapter(it)

            SelectionTracker
                .Builder(
                    "AcquisitionSelection",
                    view,
                    AcquisitionKeyProvider(it, SCOPE_MAPPED),
                    AcquisitionDetailsLookup(view),
                    StorageStrategy.createParcelableStorage(Acquisition::class.java)
                )
                .withSelectionPredicate(createSelectAnything())
                .build()
                .let { selectionTracker ->
                    acquisitionTracker = selectionTracker
                    (view.adapter as? AcquisitionAdapter)?.tracker = selectionTracker
                }
        }
    }

    fun showWalletModifier(button: Button) {
        val dialog = ScopedBottomSheetDialog(button.context, WalletModifierScope) { selectedItem -> TODO("Action for $selectedItem.") }
        button.setOnClickListener { dialog.show() }
    }

    init {
        withFab(R.drawable.ic_add) {
            setOnClickListener { fragment.findNavController().navigate(R.id.action_walletFragment_to_acquisitionComposerFragment) }
        }
    }
}