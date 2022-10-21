package com.example.relationshipnested.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "widgets_groups")
data class WidgetsGroupEntity(
    val sectionId: Long,
    val order: Int,
    val title: String,
    val disposition: String,
    val columns: Int,
    val rows:Int
){
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
}
