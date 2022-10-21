package com.example.relationshipnested.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wide_card_footers")
data class WideCardFooterEntity(
    val wideCardId: Long,
    val icon: String,
    val text: String,
){
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
}
