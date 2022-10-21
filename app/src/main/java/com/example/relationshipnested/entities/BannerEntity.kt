package com.example.relationshipnested.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "banners")
data class BannerEntity(
    val widgetGroupId: Long,
    val imageUrl: String,
    val visible: Boolean,
){
    @PrimaryKey( autoGenerate = true )
    val id: Long = 0L
}
