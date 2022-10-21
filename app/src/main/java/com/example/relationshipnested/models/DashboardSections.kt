package com.example.relationshipnested.models

data class DashboardSections(
    val purchases: Section? = null,
    val payments: Section? = null,
    val entertainment: Section? = null,
)
