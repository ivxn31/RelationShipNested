package com.example.relationshipnested.models

data class Section(
    val title: String,
    val theme: Theme?,
    val order: Int = 1,
    val icon: String,
    val enabled: Boolean = true,
    val widgets: List<WidgetGroup> = listOf(),
)
