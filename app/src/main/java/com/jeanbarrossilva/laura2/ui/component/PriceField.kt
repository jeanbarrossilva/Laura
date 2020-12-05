package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.ExperimentalFocus
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.jeanbarrossilva.laura2.R
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.extension.CurrencyX.localCurrency
import java.util.*

@ExperimentalFocus
@Composable
fun PriceField(modifier: Modifier = Modifier, currency: Currency = localCurrency(), onPriceChange: (String) -> Unit = { }) {
    LauraTheme.Wrap {
        Row(
            modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                currency.symbol,
                Modifier.fillMaxWidth(fraction = 0.3f),
                textAlign = TextAlign.Center
            )

            LauraTextField(
                Modifier.fillMaxWidth(fraction = 0.7f),
                onValueChange = onPriceChange,
                label = stringResource(R.string.BalanceInfluenceComposer_hint_value),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}