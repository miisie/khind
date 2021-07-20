package com.example.khind.Model.model.database.SignIn

import com.google.gson.annotations.SerializedName

data class Signin(
    @SerializedName("status") val statusLogin: Boolean,
    @SerializedName("data") val data: Data
)
