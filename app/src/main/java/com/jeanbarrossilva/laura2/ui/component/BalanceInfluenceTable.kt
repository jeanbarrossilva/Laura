package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.BalanceInfluenceTableDetail
import com.jeanbarrossilva.lauradata.Wallet
import com.jeanbarrossilva.lauradata.extension.NumberX.formattedAsCurrency

@Composable
fun BalanceInfluenceTable(modifier: Modifier = Modifier, wallet: Wallet, influence: BalanceInfluence) {
	val details = listOf(
		BalanceInfluenceTableDetail(title = "Amount", representation = influence.amount.formattedAsCurrency(wallet.currency))
	)

	LauraTheme.Wrap {
		Column(
			modifier,
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			details.forEach { detail ->
				Row(Modifier.fillMaxWidth()) {
					Text(
						detail.title,
						Modifier
							.fillMaxWidth(fraction = 0.5f)
							.alpha(ContentAlpha.medium)
					)

					Text(
						detail.representation.toString(),
						Modifier.fillMaxWidth(),
						fontWeight = FontWeight.Bold,
						textAlign = TextAlign.End
					)
				}
			}
		}
	}
}