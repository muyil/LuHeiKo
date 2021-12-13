package com.example.luheiko

import com.google.gson.annotations.SerializedName

data class Temperature(

    @SerializedName("Id")
    val id: Int,

    @SerializedName("Temperature")
    val temperature: Int,

    @SerializedName("MessuredDay")
    val messuredDay: String,

    @SerializedName("Description")
    val description: String
)
