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
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@Composable
fun BalanceInfluenceCardFor(influence: BalanceInfluence, onClick: () -> Unit = { }) {
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
				Row(
					Modifier.weight(0.85f),
					horizontalArrangement = Arrangement.spacedBy(30.dp)
				) {
					Box(
						Modifier
							.size(60.dp)
							.background(color = LauraTheme.Color.balanceInfluenceIconBackground(), shape = RoundedCornerShape(20.dp))
							.padding(20.dp),
						alignment = Alignment.Center
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
							"R$ 16,099.00",
							fontSize = 25.sp,
							fontWeight = FontWeight.Bold,
							maxLines = 1
						)
					}
				}

				Box(
					Modifier.weight(0.15f),
					alignment = Alignment.CenterEnd
				) {
					Icon(
						if (influence.decreases) Icons.Rounded.KeyboardArrowDown else Icons.Rounded.KeyboardArrowUp,
						Modifier
							.fillMaxWidth()
							.aspectRatio(1f),
						tint = if (influence.decreases) Color.Red else Color.Green
					)
				}
			}
		}
	}
}