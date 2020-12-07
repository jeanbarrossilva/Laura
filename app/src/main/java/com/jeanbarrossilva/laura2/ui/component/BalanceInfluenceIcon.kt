package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.ui.default.LauraTheme
import com.jeanbarrossilva.lauradata.BalanceInfluence

@Composable
fun BalanceInfluenceIcon(modifier: Modifier = Modifier, size: Dp = 24.dp, influence: BalanceInfluence) {
	LauraTheme.Wrap {
		Box(
			Modifier
				.sizeIn(60.dp)
				.background(color = LauraTheme.Color.balanceInfluenceIconBackground(), shape = RoundedCornerShape(20.dp))
				.padding(20.dp)
				.then(modifier),
			contentAlignment = Alignment.Center
		) {
			Icon(
				Icons.Rounded.Favorite,
				Modifier.size(size)
			)
		}
	}
}