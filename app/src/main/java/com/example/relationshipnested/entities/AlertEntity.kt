package com.example.relationshipnested.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alerts")
data class AlertEntity(
    val widgetGroupId: Long,
    val title: String,
    val subTitle: String,
    val icon: String,
){
    @PrimaryKey( autoGenerate = true )
    val id: Long = 0L
}
