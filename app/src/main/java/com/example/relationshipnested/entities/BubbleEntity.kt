package com.example.relationshipnested.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bubbles")
data class BubbleEntity(
    val widgetGroupId: Long,
    val title: String,
    val order: Int,
    val icon: String,
    val themeId: Long = 0L,
){
    @PrimaryKey( autoGenerate = true )
    val id: Long = 0L
}
