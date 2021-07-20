package com.example.khind.ViewModels


import android.content.Context
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.khind.Model.model.ApiService.ApiClient
import com.example.khind.Model.model.ApiService.Repository
import com.example.khind.Model.model.database.Messages.Message
import com.example.khind.Model.model.database.RefreshToken.Refresh
import com.example.khind.Model.model.database.Sensors.Sensor
import com.example.khind.Model.model.database.SensorsID.SensorID
import com.example.khind.Model.model.database.SignIn.Signin
import com.example.khind.PASSWORD

import com.example.khind.USERNAME
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityViewModel(): ViewModel() {
    var signinViewModel: MutableLiveData<Signin>? = MutableLiveData<Signin>()
    var sensorsViewModel: MutableLiveData<Sensor>? = MutableLiveData<Sensor>()
    var sensorIDViewModel: MutableLiveData<SensorID>? = MutableLiveData<SensorID>()
    var refreshViewModel: MutableLiveData<Refresh>? = MutableLiveData<Refresh>()
    var messagesViewModel: MutableLiveData<Message>? = MutableLiveData<Message>()
    private val api: ApiClient
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://khind.vinova.sg/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiClient::class.java)
    }

    //login
    fun SignIn(email: String, password: String) {
        api.SignIn(email= email,password = password)
            .enqueue(object : Callback<Signin> {
                override fun onResponse(
                    call: Call<Signin>,
                    response: Response<Signin>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                           /* Log.d("SignIn", "token: ${responseBody.data.token.tokenUse}")
                            Log.d("SignIn", "refresh_token: ${responseBody.data.token.refresh_token}")*/
                            signinViewModel?.value = Signin(responseBody.statusLogin,responseBody.data)
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
    }

    //sensor
    fun GetSensor(tokenUse: String){
        api.GetSensor(tokenUse= tokenUse)
            .enqueue(object : Callback<Sensor> {
                override fun onResponse(
                    call: Call<Sensor>,
                    response: Response<Sensor>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            /*Log.d("Sensor", "Sensor-id: ${responseBody.dataSensor[0].idSensor}")
                            Log.d("Sensor", "Sensor: ${responseBody.dataSensor[0].alarm}")*/
                            sensorsViewModel?.value = Sensor(responseBody.dataSensor,responseBody.statusSensor)
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
    }

    //sensorID
    fun GetSensorID(tokenUse: String, id: String){
        api.GetSensorID(tokenUse= tokenUse, Id = id)
            .enqueue(object : Callback<SensorID> {
                override fun onResponse(
                    call: Call<SensorID>,
                    response: Response<SensorID>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                           /* Log.d("SensorID", "SensorID: ${responseBody.dataSensorID.idSensor}")
                            Log.d("SensorID", "SensorID: ${responseBody.dataSensorID.alarm}")*/
                            sensorIDViewModel?.value = SensorID(responseBody.dataSensorID,responseBody.statusSensorID)
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
    }

    //refresh
    fun RefreshToken(tokenUse: String, refreshToken: String){
        api.RefreshToken(tokenUse= tokenUse,refreshToken = refreshToken)
            .enqueue(object : Callback<Refresh> {
                override fun onResponse(
                    call: Call<Refresh>,
                    response: Response<Refresh>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            /*Log.d("Refresh", "tokenRefreshUse: ${responseBody.datarefresh.tokenRefresh.tokenRefreshUse}")
                            Log.d("Refresh", "refreshTokenRefreshUse: ${responseBody.datarefresh.tokenRefresh.refreshTokenRefreshUse}")*/
                            refreshViewModel?.value = Refresh(responseBody.datarefresh,responseBody.statusrefresh)
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
    }

    fun signinViewModelObserve(username: String, password: String): LiveData<Signin>?{
        SignIn(username,password)
        return signinViewModel
    }

    fun sensorsViewModelObserve(token: String): LiveData<Sensor>?{
        GetSensor(token)
        return sensorsViewModel
    }
    fun sensorIDViewModelObserve(token: String, id:String): LiveData<SensorID>?{
        GetSensorID(token,id)
        return sensorIDViewModel
    }
    fun refreshViewModelObserve(token: String,refreshtoken:String): LiveData<Refresh>?{
        RefreshToken(token,refreshtoken)
        return refreshViewModel
    }
    fun messagesViewModelObserve(context: Context): LiveData<Message>? {

        return messagesViewModel
    }
}