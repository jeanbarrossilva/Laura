package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.BalanceInfluenceType.Debit
import com.jeanbarrossilva.lauradata.BalanceInfluenceType.Rise
import com.jeanbarrossilva.lauradata.Wallet
import com.jeanbarrossilva.lauradata.extension.NumberX.formattedAsCurrency

@ExperimentalLayout
@Composable
fun BalanceInfluenceCard(wallet: Wallet, influence: BalanceInfluence, onClick: () -> Unit = { }) {
	val (indicatorIcon, indicatorColor) = when (influence.type) {
		Debit -> Icons.Rounded.KeyboardArrowDown to Color.Red
		Rise -> Icons.Rounded.KeyboardArrowUp to Color.Green
	}

	LauraTheme.Wrap {
		Card(
			Modifier
				.fillMaxWidth()
				.clickable { onClick() },
			shape = RectangleShape
		) {
			Row(
				Modifier
					.fillMaxWidth()
					.padding(vertical = 20.dp, horizontal = 30.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				Box(Modifier.fillMaxWidth(fraction = 0.85f)) {
					FlowRow(
						mainAxisSize = SizeMode.Wrap,
						mainAxisSpacing = 30.dp
					) {
						Box(
							Modifier
								.size(60.dp)
								.background(color = LauraTheme.Color.balanceInfluenceIconBackground(), shape = RoundedCornerShape(20.dp))
								.padding(20.dp),
							contentAlignment = Alignment.Center
						) {
							Icon(Icons.Rounded.Favorite)
						}

						Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
							Text(
								influence.name,
								color = MaterialTheme.colors.onSecondary.copy(alpha = 0.5f),
								fontSize = 16.sp,
								fontFamily = LauraTheme.FontFamily.syne,
								maxLines = 1
							)

							Text(
								influence.amount.formattedAsCurrency(wallet.currency),
								fontSize = 25.sp,
								fontWeight = FontWeight.Bold,
								maxLines = 1
							)
						}
					}
				}

				Box(
					Modifier.weight(0.15f),
					contentAlignment = Alignment.CenterEnd
				) {
					Icon(
						indicatorIcon,
						Modifier
							.fillMaxWidth()
							.aspectRatio(1f),
						tint = indicatorColor
					)
				}
			}
		}
	}
}