package com.example.khind.Model.model.database.SignIn

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("token") val tokenUse : String,
    @SerializedName("refresh_token") val refresh_token : String
)
