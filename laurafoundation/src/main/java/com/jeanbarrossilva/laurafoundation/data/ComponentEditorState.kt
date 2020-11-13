package com.jeanbarrossilva.laurafoundation.data

sealed class ComponentEditorState {
    object NonEditingState : ComponentEditorState()
    object EditingState : ComponentEditorState()

    fun <T> ifEditing(block: () -> T?) = if (this is EditingState) block() else null
}