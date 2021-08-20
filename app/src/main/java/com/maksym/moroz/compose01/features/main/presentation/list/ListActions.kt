package com.maksym.moroz.compose01.features.main.presentation.list

internal data class ListActions(
    val onToDoClicked: (Int) -> Unit,
    val onGotAToDoClicked: () -> Unit,
)