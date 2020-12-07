package com.jeanbarrossilva.laura2.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeanbarrossilva.laura2.ui.component.BalanceInfluenceIcon
import com.jeanbarrossilva.laura2.ui.component.BalanceInfluenceTable
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.Wallet
import com.jeanbarrossilva.lauradata.extension.StringX.capitalized
import com.jeanbarrossilva.lauradata.extension.StringX.lowerCased

@Composable
fun BalanceInfluenceUI(wallet: Wallet, influence: BalanceInfluence) {
	val standardRegistrationText = with(influence.registrationDateTime) { "Registered on ${month.name.lowerCased.capitalized} $dayOfMonth, $year" }
	val expandedRegistrationText = with(influence.registrationDateTime) { "$standardRegistrationText, $hour:$minute" }
	var registrationDateTimeText by remember { mutableStateOf(standardRegistrationText) }
	var didExpandRegistrationText by mutableStateOf(false)

	LauraTheme.Fill {
		Column(
			Modifier
				.fillMaxWidth()
				.padding(30.dp),
			verticalArrangement = Arrangement.spacedBy(60.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Column(
				verticalArrangement = Arrangement.spacedBy(30.dp),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				BalanceInfluenceIcon(
					Modifier.size(40.dp),
					size = 20.dp,
					influence
				)

				Column(
					verticalArrangement = Arrangement.spacedBy(5.dp),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					Text(
						influence.name,
						fontSize = 40.sp,
						fontWeight = FontWeight.Bold
					)

					Text(
						registrationDateTimeText,
						Modifier
							.alpha(ContentAlpha.medium)
							.clickable(indication = null) {
								didExpandRegistrationText = didExpandRegistrationText.not()
								registrationDateTimeText = if (didExpandRegistrationText) expandedRegistrationText else standardRegistrationText
							},
						fontSize = 17.sp
					)
				}
			}

			BalanceInfluenceTable(
				Modifier.fillMaxWidth(),
				wallet,
				influence
			)
		}
	}
}