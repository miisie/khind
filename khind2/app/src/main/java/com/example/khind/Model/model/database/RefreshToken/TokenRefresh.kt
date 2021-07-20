package com.example.khind.Model.model.database.RefreshToken

import com.google.gson.annotations.SerializedName

data class TokenRefresh(
    @SerializedName("token") val tokenRefreshUse: String,
    @SerializedName("refresh_token") val refreshTokenRefreshUse: String
)