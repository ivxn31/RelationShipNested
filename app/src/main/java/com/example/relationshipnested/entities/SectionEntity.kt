package com.example.relationshipnested.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sections")
data class SectionEntity(
    val dashboardId: Long,
    val themeId: Long = 0L,
    val title: String,
    val order: Int,
    val icon: String,
    val enabled: Boolean = true,
    val associatedEventReferenceId: Int? = null,
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L
}
