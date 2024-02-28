package com.dubproductions.empowertakehome.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val firstLineMailing: String,
    val scndLineMailing: String?,
    val city: String,
    val zipCode: String,
    val stateCode: String,
    val country: String
)
