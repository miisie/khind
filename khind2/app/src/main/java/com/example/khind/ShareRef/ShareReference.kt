package com.example.khind.ShareRef

import android.content.Context
import android.content.SharedPreferences
import com.example.khind.*


/*class ShareReference() {
    private fun String.put(float: Float, context: Context) {
        val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putFloat(this, float)
        editor.commit()
    }

    private fun String.put(string: String, context: Context) {
        val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString(this, string)
        editor.commit()
    }

    private fun String.put(boolean: Boolean, context: Context) {
        val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean(this, boolean)
        editor.commit()
    }

    private fun String.getFloat(context: Context){
        val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        pref.getFloat(this, 0.0f)
    }

    private fun String.getString(context: Context) {
        val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        pref.getString(this, "")!!
    }

    private fun String.getBoolean(context: Context) {
        val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        pref.getBoolean(this, false)

    }

    fun putUsername(username: String,context: Context) {
        USERNAME.put(username,context)
    }
    fun putPassword(password: String,context: Context){
        PASSWORD.put(password,context)
    }
    fun getUsername(context: Context) = USERNAME.getString(context).toString()
    fun getPassword(context: Context) = PASSWORD.getString(context).toString()


    fun isLoggedIn(status: Boolean,context:Context) {
        LOGGED_IN.put(status,context)
    }

    fun checkLoggedIn(context: Context) = LOGGED_IN.getBoolean(context).toString()

    fun putToken(Token: String, RefreshToken: String,context:Context) {
        TOKEN.put(Token,context)
        REFRESH_TOKEN.put(RefreshToken,context)
    }

    fun getToken(context: Context) = TOKEN.getString(context).toString()

    fun getRefeshToken(context: Context) = REFRESH_TOKEN.getString(context).toString()

    fun putSensorId(id: String,context:Context) {
        SENSOR_ID.put(id,context)
    }

    fun getSensorId(context: Context) = SENSOR_ID.getString(context).toString()

    fun putAlarm(alarm : String,context:Context){
        ALARM.put(alarm,context)
    }
    fun getAlarm(context: Context) = ALARM.getString(context).toString()

    fun putLongitude(longitude : Float,context:Context){
        LONGITUDE.put(longitude,context)
    }
    fun getLongitude(context: Context) = LONGITUDE.getFloat(context)

    fun putLatitude(longitude : Float,context:Context){
        LONGITUDE.put(longitude,context)
    }
    fun getLatitude(context: Context) = LATITUDE.getFloat(context)

    fun clear(context: Context) {
        val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.commit()
    }

}*/


class ShareReference(val context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    private val editor = pref.edit()


    private fun String.put(float: Float) {
        editor.putFloat(this, float)
        editor.commit()
    }

    private fun String.put(string: String) {
        editor.putString(this, string)
        editor.commit()
    }

    private fun String.put(boolean: Boolean) {
        editor.putBoolean(this, boolean)
        editor.commit()
    }

    private fun String.getFloat() = pref.getFloat(this, 0.0f)

    private fun String.getString() = pref.getString(this, "")!!

    private fun String.getBoolean() = pref.getBoolean(this, false)

    fun putToken(Token: String, RefreshToken: String) {
        TOKEN.put(Token)
        REFRESH_TOKEN.put(RefreshToken)
    }

    fun getToken() = TOKEN.getString()
    fun getRefeshToken() = REFRESH_TOKEN.getString()

    fun putSensorId(id: String) {
        SENSOR_ID.put(id)
    }

    fun getSensorId() = SENSOR_ID.getString()
    fun putAlarm(alarm : String){
        ALARM.put(alarm)
    }
    fun getAlarm() = ALARM.getString()

    fun putLongitude(longitude : Float){
        LONGITUDE.put(longitude)
    }
    fun getLongitude() = LONGITUDE.getFloat()

    fun putLatitude(latitude : Float){
        LATITUDE.put(latitude)
    }
    fun getLatitude() = LATITUDE.getFloat()

    fun putTime(time :String){
        TIME.put(time)
    }
    fun getTime() = TIME.getString()




    fun clear() {
        editor.clear()
        editor.commit()
    }
}
