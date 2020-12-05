package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@Composable
fun LauraTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit = { _ -> }
) {
    LauraTheme.Wrap {
        OutlinedTextField(
            value,
            onValueChange,
            modifier,
            label = { Text(label) },
            keyboardOptions = keyboardOptions
        )
    }
}