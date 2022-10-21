package com.example.relationshipnested.models

data class WideCard(
    val title: String,
    val subTitle: String,
    val imageUrl: String,
    val imageAsset: String,
    val footer: WideCardFooter,
)
