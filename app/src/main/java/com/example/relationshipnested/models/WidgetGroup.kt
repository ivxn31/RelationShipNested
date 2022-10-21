package com.example.relationshipnested.models

import com.example.relationshipnested.enums.Disposition

data class WidgetGroup(
    val title: String,
    val order: Int,
    val disposition: Disposition,
    val columns: Int,
    val rows: Int,
    val bubbles: List<Bubble> = listOf(),
    val alerts: List<Alert> = listOf(),
    val banners: List<Banner> = listOf(),
    val wideCards: List<WideCard> = listOf(),
)
