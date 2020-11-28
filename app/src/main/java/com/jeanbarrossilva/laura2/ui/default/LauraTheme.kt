package com.jeanbarrossilva.laura2.ui.default

import androidx.annotation.FontRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.asFontFamily
import androidx.compose.ui.text.font.font
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.R

object LauraTheme {
    private val typography = Typography(FontFamily.rubik)
    private val shapes = Shapes(Shape.small, Shape.medium, Shape.large)

    object Color {
        private val primary = Color(16, 169, 255)
        private val primaryVariant = Color(13, 145, 220)
        private val secondary = Color(255, 88, 88)

        object Palette {
            private val light = lightColors(primary, primaryVariant, secondary)
            private val dark = darkColors(primary, primaryVariant, secondary)

            @Composable
            fun dynamic() = if (isSystemInDarkTheme()) dark else light
        }

        @Composable
        fun balanceInfluenceIconBackground() = if (isSystemInDarkTheme()) Color(44, 44, 44) else Color(250, 250, 250)
    }

    object FontFamily {
        val rubik = get(R.font.rubik)
        val syne = get(R.font.syne)

        private fun get(@FontRes res: Int) = font(res).asFontFamily()
    }

    private object Shape {
        val small = RoundedCornerShape(5.dp)
        val medium = RoundedCornerShape(10.dp)
        val large = RoundedCornerShape(15.dp)
    }

    @Composable
    private fun get(content: @Composable () -> Unit) = MaterialTheme(colors = Color.Palette.dynamic(), typography, shapes, content)

    @Composable
    fun Wrap(content: @Composable () -> Unit) = get(content)

    @Composable
    fun Fill(content: @Composable () -> Unit) {
        get {
            Surface(Modifier.fillMaxSize()) {
                content()
            }
        }
    }
}