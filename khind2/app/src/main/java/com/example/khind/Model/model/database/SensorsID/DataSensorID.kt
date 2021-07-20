package com.example.khind.Model.model.database.SensorsID

import com.google.gson.annotations.SerializedName

data class DataSensorID(
    @SerializedName("id") val idSensor: String,
    @SerializedName("alarm") val alarm: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
)