package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeanbarrossilva.lauradata.extension.StringX.upperCased
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.extension.NumberX.currencyFormat
import java.util.Currency

@Composable
fun WalletInfoCard(name: String = "", currency: Currency, balance: Float, onModifyClick: () -> Unit = { }) {
	LauraTheme.Wrap {
		Column(Modifier.padding(20.dp)) {
			Card(
				Modifier.fillMaxWidth(),
				shape = RoundedCornerShape(15.dp)
			) {
				Row(
					Modifier.padding(40.dp),
					verticalAlignment = Alignment.CenterVertically
				) {
					Column(
						Modifier.weight(0.8f),
						verticalArrangement = Arrangement.spacedBy(5.dp)
					) {
						Text(
							name.upperCased,
							Modifier.drawOpacity(0.5f),
							color = MaterialTheme.colors.onSecondary,
							overflow = TextOverflow.Ellipsis,
							maxLines = 1
						)

						Text(
							"${currency.symbol} ${currencyFormat.format(balance)}",
							fontSize = 30.sp,
							fontWeight = FontWeight.Bold,
							maxLines = 1
						)
					}

					Box(
						Modifier.weight(0.15f),
						alignment = Alignment.CenterEnd
					) {
						IconButton(
							onModifyClick,
							Modifier
								.fillMaxWidth()
								.aspectRatio(1f)
								.border(width = 1.dp, color = MaterialTheme.colors.onSecondary.copy(alpha = 0.1f), shape = CircleShape),
							icon = {
								Icon(
									Icons.Rounded.Settings,
									Modifier.size(20.dp),
									tint = MaterialTheme.colors.primary
								)
							}
						)
					}
				}
			}
		}
	}
}