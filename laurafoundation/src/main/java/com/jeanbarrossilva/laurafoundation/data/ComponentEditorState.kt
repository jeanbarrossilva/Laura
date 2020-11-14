package com.jeanbarrossilva.laurafoundation.data

sealed class ComponentEditorState {
    object NonEditingState : ComponentEditorState()
    object EditingState : ComponentEditorState()

    fun isEditing() = this is EditingState

    fun <T> ifEditing(block: () -> T?) = if (isEditing()) block() else null
}