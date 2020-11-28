package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@ExperimentalMaterialApi
@Composable
fun ModalBottomSheetLayoutItem(state: ModalBottomSheetState?, icon: VectorAsset, title: String, onClick: () -> Unit = { }) {
	LauraTheme.Wrap {
		ModalDrawerLayoutItem(
			Modifier.padding(vertical = 10.dp),
			spacing = 25.dp,
			icon,
			title,
			selectsOnClick = false
		) {
			state?.hide()
			onClick()
		}
	}
}