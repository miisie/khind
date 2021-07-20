package com.example.khind.Model.model.ApiService

import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import com.example.khind.Model.model.database.Messages.Message
import com.example.khind.Model.model.database.RefreshToken.Refresh
import com.example.khind.Model.model.database.Sensors.Sensor
import com.example.khind.Model.model.database.SensorsID.SensorID
import com.example.khind.Model.model.database.SignIn.Signin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {
    var signinViewModel = MutableLiveData<Signin>()
    var sensorsViewModel= MutableLiveData<Sensor>()
    var sensorIDViewModel= MutableLiveData<SensorID>()
    var refreshViewModel= MutableLiveData<Refresh>()
    var messagesViewModel= MutableLiveData<Message>()
    private val api: ApiClient
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://khind.vinova.sg/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiClient::class.java)
    }
     fun SignIn(email: String, password: String): MutableLiveData<Signin> {
        api.SignIn(email= email,password = password)
            .enqueue(object : Callback<Signin> {
                override fun onResponse(
                    call: Call<Signin>,
                    response: Response<Signin>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            Log.d("SignIn", "token: ${responseBody.data.token.tokenUse}")
                            Log.d("SignIn", "refresh_token: ${responseBody.data.token.refresh_token}")
                            signinViewModel.value = Signin(responseBody.statusLogin,responseBody.data)
                        } else {
                            Log.d("SignIn", "Failed to get response 1")
                        }
                    }else{
                        Log.d("SignIn", "Failed to get response 2")
                    }
                }

                override fun onFailure(call: Call<Signin>, t: Throwable) {
                    Log.e("SignIn", "onFailure", t)
                }
            })
        return signinViewModel
    }
    fun RefreshToken(tokenUse: String, refreshToken: String): MutableLiveData<Refresh> {
        api.RefreshToken(tokenUse= tokenUse,refreshToken = refreshToken)
            .enqueue(object : Callback<Refresh> {
                override fun onResponse(
                    call: Call<Refresh>,
                    response: Response<Refresh>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            Log.d("Refresh", "tokenRefreshUse: ${responseBody.datarefresh.tokenRefresh.tokenRefreshUse}")
                            Log.d("Refresh", "refreshTokenRefreshUse: ${responseBody.datarefresh.tokenRefresh.refreshTokenRefreshUse}")
                            refreshViewModel.value = Refresh(responseBody.datarefresh,responseBody.statusrefresh)
                        } else {
                            Log.d("Refresh", "Failed to get response 1")
                        }
                    }else{
                        Log.d("Refresh", "Failed to get response 2")
                    }
                }

                override fun onFailure(call: Call<Refresh>, t: Throwable) {
                    Log.e("Refresh", "onFailure", t)
                }
            })
        return refreshViewModel
    }
    fun GetSensor(tokenUse: String): MutableLiveData<Sensor> {
        api.GetSensor(tokenUse= tokenUse)
            .enqueue(object : Callback<Sensor> {
                override fun onResponse(
                    call: Call<Sensor>,
                    response: Response<Sensor>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            Log.d("Sensor", "Sensor: ${responseBody.dataSensor[0].idSensor}")
                            Log.d("Sensor", "Sensor: ${responseBody.dataSensor[0].alarm}")
                            sensorsViewModel.value = Sensor(responseBody.dataSensor,responseBody.statusSensor)
                        } else {
                            Log.d("Fail1", "Failed to get response 1")
                        }
                    }else{
                        Log.d("Fail2", "Failed to get response 2")
                    }
                }override fun onFailure(call: Call<Sensor>, t: Throwable) {
                    Log.e("Sensor", "onFailure", t)
                }


            })
        return sensorsViewModel
    }
    fun GetSensorID(tokenUse: String, id: String): MutableLiveData<SensorID>{
        api.GetSensorID(tokenUse= tokenUse, Id = id)
            .enqueue(object : Callback<SensorID> {
                override fun onResponse(
                    call: Call<SensorID>,
                    response: Response<SensorID>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            Log.d("SensorID", "SensorID: ${responseBody.dataSensorID.idSensor}")
                            Log.d("SensorID", "SensorID: ${responseBody.dataSensorID.alarm}")
                            sensorIDViewModel.value = SensorID(responseBody.dataSensorID,responseBody.statusSensorID)
                        } else {
                            Log.d("Fail3", "Failed to get response 1")
                        }
                    }else{
                        Log.d("Fail4", "Failed to get response 2")
                    }
                }

                override fun onFailure(call: Call<SensorID>, t: Throwable) {
                    Log.e("Sensor", "onFailure", t)
                }
            })
        return sensorIDViewModel
    }
}