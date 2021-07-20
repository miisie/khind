package com.example.khind.Model.model.database.SensorsID

import com.google.gson.annotations.SerializedName

data class SensorID(
    @SerializedName("data") val dataSensorID: DataSensorID,
    @SerializedName("status") val statusSensorID: Boolean
)
