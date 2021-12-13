package com.example.luheiko

import com.google.gson.annotations.SerializedName

data class Humidity(
    @SerializedName("Id")
    val id: Int,

    @SerializedName("Humidity")
    val humidity: Int,

    @SerializedName("MessuredDay")
    val messuredDay: String,

    @SerializedName("Description")
    val description: String
)
