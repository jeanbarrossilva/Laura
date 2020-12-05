package com.jeanbarrossilva.laura2.extension

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

object ColumnX {
	@Composable
	fun ModalDrawerLayoutColumn(content: @Composable ColumnScope.() -> Unit) {
		LauraTheme.Wrap {
			Column(Modifier.padding(horizontal = 5.dp)) {
				Spacer(Modifier.height(10.dp))
				content(this)
			}
		}
	}
}