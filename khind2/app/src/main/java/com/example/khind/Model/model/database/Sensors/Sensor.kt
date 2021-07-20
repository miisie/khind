package com.example.khind.Model.model.database.Sensors


import com.google.gson.annotations.SerializedName

data class Sensor (
    @SerializedName("data") val dataSensor: List<DataSensor>,
    @SerializedName("status") val statusSensor: Boolean
)