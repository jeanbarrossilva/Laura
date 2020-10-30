package com.jeanbarrossilva.laura.ui.viewmodel

import android.text.InputType.TYPE_CLASS_NUMBER
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.selection.ItemKeyProvider.SCOPE_MAPPED
import androidx.recyclerview.selection.SelectionPredicates.createSelectAnything
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.jeanbarrossilva.laura.LauraApplication
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ui.adapter.BalanceInfluenceAdapter
import com.jeanbarrossilva.laura.ui.detailslookup.AcquisitionDetailsLookup
import com.jeanbarrossilva.laura.ui.dialog.ScopedBottomSheetDialog
import com.jeanbarrossilva.laura.ui.fragment.WalletFragment
import com.jeanbarrossilva.laura.ui.keyprovider.AcquisitionKeyProvider
import com.jeanbarrossilva.laura.ui.manager.LauraLinearLayoutManager
import com.jeanbarrossilva.laurafoundation.LauraFoundation
import com.jeanbarrossilva.laurafoundation.data.Acquirer
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence
import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogItem.AddQuantityItem
import com.jeanbarrossilva.laurafoundation.data.BottomSheetDialogScope.WalletModifierScope

class WalletViewModel(private val fragment: WalletFragment) : ViewModel() {
    internal lateinit var acquisitionTracker: SelectionTracker<Long>

    @Suppress("SetTextI18n")
    fun showInfoIn(titleView: TextView, balanceView: TextView) {
        titleView.text = Acquirer.currentWallet.name
        balanceView.text = "${Acquirer.currentWallet.currency.symbol} ${LauraFoundation.currencyFormat.format(Acquirer.currentWallet.balance)}"
    }

    fun loadAcquisitionsIn(view: RecyclerView) {
        view.layoutManager = LauraLinearLayoutManager(view.context)

        LauraApplication.balanceInfluences.observe(fragment) { influences ->
            view.adapter = BalanceInfluenceAdapter(influences)

            SelectionTracker
                .Builder(
                    "BalanceInfluenceSelection",
                    view,
                    AcquisitionKeyProvider(influences, SCOPE_MAPPED),
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

    fun showWalletModifier(button: Button) {
        val dialog = ScopedBottomSheetDialog(button.context, WalletModifierScope) { selectedItem ->
            if (selectedItem is AddQuantityItem)
                MaterialDialog(button.context).show {
                    title(R.string.add_quantity)
                    message(text = context.getString(R.string.dialog_add_quantity_message).format(Acquirer.currentWallet.name))

                    input(hintRes = R.string.dialog_add_quantity_field_hint, inputType = TYPE_CLASS_NUMBER) { _, inserted ->
                        val quantity = inserted.toString().toFloat()
                        val rise = BalanceInfluence.Rise(context = context, walletId = Acquirer.currentWallet.uuid, amount = quantity)

                        Acquirer.currentWallet.balance =+ quantity
                    }

                    positiveButton(android.R.string.ok) { dismiss() }
                    negativeButton(android.R.string.cancel) { dismiss() }
                }
        }

        button.setOnClickListener { dialog.show() }
    }
}