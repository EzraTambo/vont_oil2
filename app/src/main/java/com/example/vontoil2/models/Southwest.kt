package com.example.vontoil2.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Southwest(
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lng")
    val lng: Double
)