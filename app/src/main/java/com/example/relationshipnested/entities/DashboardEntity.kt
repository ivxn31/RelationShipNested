package com.example.relationshipnested.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dashboards")
data class DashboardEntity(
    val version: String,
    val playerEnabled: Boolean,
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L
}
