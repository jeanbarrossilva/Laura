package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.extension.ColumnX.ModalLayoutColumn
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@Composable
fun LauraScaffold(
    toolbarTitle: String = "",
    drawerItems: @Composable () -> Unit = { },
    fabIcon: VectorAsset,
    onFabClick: () -> Unit = { },
    content: @Composable () -> Unit
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    LauraTheme.Wrap {
        ModalDrawerLayout(
            drawerContent = {
                ModalLayoutColumn {
                    drawerItems()
                }
            },
            drawerState = drawerState,
            drawerShape = RoundedCornerShape(topRight = 15.dp, bottomRight = 15.dp)
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(toolbarTitle) },
                        navigationIcon = {
                            IconButton(
                                onClick = { if (drawerState.isClosed) drawerState.open() else drawerState.close() },
                                icon = { Icon(Icons.Rounded.Menu) }
                            )
                        },
                        backgroundColor = MaterialTheme.colors.background,
                        elevation = 10.dp
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onFabClick,
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = Color.White
                    ) {
                        Icon(fabIcon)
                    }
                }
            ) {
                content()
            }
        }
    }
}