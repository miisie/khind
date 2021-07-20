package com.example.khind.Model.model.ApiService
import com.example.khind.Model.model.database.RefreshToken.Refresh
import com.example.khind.Model.model.database.Sensors.Sensor
import com.example.khind.Model.model.database.SensorsID.SensorID
import com.example.khind.Model.model.database.SignIn.Signin
import retrofit2.Call
import retrofit2.http.*

interface ApiClient {
    //signin
    @POST("auth/sign_in")
    fun SignIn(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<Signin>

    //refreshtoken
    @POST("auth/refresh_token")
    fun RefreshToken(
        @Query("X-Refresh-Token") tokenUse: String,
        @Query("refresh_token") refreshToken: String
    ): Call<Refresh>

    //sensors
    @GET("sensors")
    fun GetSensor(
        @Query("page") page : Int = 1,
        @Header("X-Http-Token") tokenUse: String
    ): Call<Sensor>

    //SensorsID
    @GET("sensors/{id}")
    fun GetSensorID(
        @Header("X-Http-Token") tokenUse: String,
        @Path("id") Id: String
    ): Call<SensorID>

    //Messages
}