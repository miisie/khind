package com.example.khind.fragmentActivity2.notification.alerts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.khind.R
import com.example.khind.fragmentActivity2.bottom_nav.Dashboard
import com.example.khind.fragmentActivity2.notification.Notifications
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    private lateinit var detailsBackButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val time = intent.getStringExtra("time")
        time_detail.text = time
        detailsBackButton = findViewById(R.id.backbutton_details)
        detailsBackButton.setOnClickListener {
            
        }
    }
}