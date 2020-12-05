package com.jeanbarrossilva.laura2.ui.component.provider

import androidx.ui.tooling.preview.PreviewParameterProvider
import com.jeanbarrossilva.lauradata.Wallet

class WalletPreviewParameterProvider : PreviewParameterProvider<Wallet> {
    override val values = sequenceOf(Wallet.main)
}