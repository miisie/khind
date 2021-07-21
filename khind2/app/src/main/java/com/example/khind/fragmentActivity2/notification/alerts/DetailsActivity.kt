package com.example.khind.fragmentActivity2.notification.alerts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.khind.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val time = intent.getStringExtra("time")
        time_detail.text = time
    }
}