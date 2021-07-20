package com.example.khind.Model.model.database.RefreshToken

import com.google.gson.annotations.SerializedName

data class Refresh(
    @SerializedName("data") val datarefresh: DataRefresh,
    @SerializedName("status") val statusrefresh: Boolean
)