package com.example.khind.Model.model.database.Messages

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("status") val statusMessage: Boolean
)