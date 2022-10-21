package com.example.relationshipnested.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wide_cards")
data class WideCardEntity(
    val widgetGroupId: Long,
    val title: String,
    val subTitle: String,
    val imageUrl: String,
    val imageAsset: String,
){
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
}
