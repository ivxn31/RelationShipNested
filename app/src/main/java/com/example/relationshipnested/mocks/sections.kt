package com.example.relationshipnested.mocks

import com.example.relationshipnested.mocks.entertainment.entertainmentSection
import com.example.relationshipnested.mocks.payments.paymentsSection
import com.example.relationshipnested.mocks.purchases.purchasesSection
import com.example.relationshipnested.models.DashboardSections

val sections = DashboardSections(
    purchasesSection,
    paymentsSection,
    entertainmentSection
)