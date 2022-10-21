package com.example.relationshipnested.models

data class Dashboard(
    val version: Int = 0,
    val sections: DashboardSections? = null,
    val playerEnabled: Boolean = false
)
