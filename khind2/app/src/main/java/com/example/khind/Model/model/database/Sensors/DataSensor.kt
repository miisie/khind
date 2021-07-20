package com.example.khind.Model.model.database.Sensors

import com.google.gson.annotations.SerializedName

data class DataSensor(
    @SerializedName("id") val idSensor:String,
    @SerializedName("alarm") val alarm: String
)