package com.example.lab4.ui

sealed class UiEvent {
    data object PopBackStack : UiEvent()
    data class ShowSnackBar(val message: String) : UiEvent()
}