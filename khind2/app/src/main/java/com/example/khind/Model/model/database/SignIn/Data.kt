package com.example.khind.Model.model.database.SignIn

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("token") val token: Token
)