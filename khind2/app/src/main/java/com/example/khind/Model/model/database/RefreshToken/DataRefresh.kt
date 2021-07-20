package com.example.khind.Model.model.database.RefreshToken

import com.google.gson.annotations.SerializedName

data class DataRefresh(
    @SerializedName("token") val tokenRefresh: TokenRefresh
)