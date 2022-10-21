package com.example.relationshipnested.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "themes")
data class ThemeEntity(
    val primaryBackgroundColor:   String,
    val secondaryBackgroundColor: String,
    val primaryIconColor:         String,
    val secondaryIconColor:       String,
    val primaryFontColor:         String,
    val secondaryFontColor:       String,
    val selectedBackgroundColor:  String,
){
    @PrimaryKey(autoGenerate = true)
    val id:                       Long = 0L
}
