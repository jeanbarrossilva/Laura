package com.jeanbarrossilva.laura2.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.laura2.extension.ColumnX.ModalDrawerLayoutColumn
import com.jeanbarrossilva.laura2.ui.default.LauraTheme

@Composable
fun LauraScaffold(
    toolbarIcon: ImageVector,
    onToolbarButtonClick: (DrawerState) -> Unit = { _ -> },
    toolbarTitle: String = "",
    drawerItems: @Composable () -> Unit = { },
    fabIcon: ImageVector,
    onFabClick: () -> Unit = { },
    content: @Composable () -> Unit
) {
    val toolbarContentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    LauraTheme.Wrap {
        ModalDrawerLayout(
            drawerContent = {
                ModalDrawerLayoutColumn {
                    drawerItems()
                }
            },
            drawerState = drawerState,
            drawerShape = RoundedCornerShape(topRight = 15.dp, bottomRight = 15.dp)
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                toolbarTitle,
                                color = toolbarContentColor
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = { onToolbarButtonClick(drawerState) }) {
                                Icon(
                                    toolbarIcon,
                                    tint = toolbarContentColor
                                )
                            }
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