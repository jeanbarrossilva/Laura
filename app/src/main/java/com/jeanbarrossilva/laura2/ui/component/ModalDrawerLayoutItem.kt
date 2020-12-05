package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@Composable
fun ModalDrawerLayoutItem(
	modifier: Modifier = Modifier,
	spacing: Dp = 20.dp,
	icon: ImageVector,
	title: String,
	isSelected: Boolean = false,
	selectsOnClick: Boolean = true,
	onSelect: () -> Unit = { }
) {
	@Suppress("LocalVariableName")
	var _isSelected by remember { mutableStateOf(isSelected) }

	val backgroundColor = if (_isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
	val contentColor = if (_isSelected) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.onSurface

	LauraTheme.Wrap {
		Row(
			Modifier
				.fillMaxWidth(0.95f)
				.background(backgroundColor, RoundedCornerShape(5.dp))
				.clickable {
					onSelect()
					if (selectsOnClick) _isSelected = true
				}
				.padding(vertical = 10.dp, horizontal = 20.dp)
				.then(modifier),
			horizontalArrangement = Arrangement.spacedBy(spacing),
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				icon,
				tint = contentColor
			)

			Text(
				title,
				color = contentColor
			)
		}
	}
}