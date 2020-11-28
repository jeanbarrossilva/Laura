package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@Composable
fun ModalBottomSheetLayoutItem(icon: VectorAsset, title: String, onClick: () -> Unit = { }) {
	LauraTheme.Wrap {
		ModalDrawerLayoutItem(
			Modifier.padding(vertical = 10.dp),
			spacing = 25.dp,
			icon,
			title,
			selectsOnClick = false,
			onSelect = onClick
		)
	}
}