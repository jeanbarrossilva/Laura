package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@Composable
fun LauraTextField(modifier: Modifier = Modifier, value: String = "", label: String = "", onValueChange: (String) -> Unit = { _ -> }) {
    var text by remember { mutableStateOf(if (value.isEmpty()) label else value) }

    LauraTheme.Wrap {
        BasicTextField(
            text,
            onValueChange = {
                text = it
                onValueChange(it)
            },
            Modifier
                .padding(vertical = 20.dp, horizontal = 10.dp)
                .border(1.5.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(10.dp))
                .then(modifier)
        )
    }
}