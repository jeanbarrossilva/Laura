package com.jeanbarrossilva.laura2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.ExperimentalFocus
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.R
import com.jeanbarrossilva.laura2.ui.component.LauraTextField
import com.jeanbarrossilva.laura2.ui.component.PriceField
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import java.util.*

@ExperimentalFocus
@Composable
fun BalanceInfluenceComposerUI(currency: Currency) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf<Float?>(null) }

    LauraTheme.Fill {
        Column(
            Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            LauraTextField(
                Modifier.fillMaxWidth(),
                label = stringResource(R.string.BalanceInfluenceComposer_hint_name)
            ) {
                name = it
            }

            PriceField(
                Modifier.fillMaxWidth(),
                currency
            ) {
                price = it.toFloatOrNull()
            }
        }
    }
}