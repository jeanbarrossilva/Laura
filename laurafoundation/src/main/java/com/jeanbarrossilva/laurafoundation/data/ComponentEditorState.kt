package com.jeanbarrossilva.laurafoundation.data

sealed class ComponentEditorState {
    object NonEditingState : ComponentEditorState()
    object EditingState : ComponentEditorState()
}