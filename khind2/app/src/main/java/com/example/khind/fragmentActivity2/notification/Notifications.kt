package com.example.khind.fragmentActivity2.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.khind.R
import com.example.khind.fragmentActivity2.notification.alerts.Alerts
import com.example.khind.fragmentActivity2.notification.messages.Messages
import com.google.android.material.tabs.TabLayout

class Notifications : Fragment() {
    lateinit var tablayout : TabLayout
    lateinit var  viewpager : ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapt = ViewPagerAdapter(childFragmentManager)
        tablayout = view.findViewById(R.id.tabs)
        viewpager = view.findViewById(R.id.viewPager)
        adapt.addFragment(Messages(),"Messages")
        adapt.addFragment(Alerts(),"Alerts")
        viewpager.adapter = adapt
        tablayout.setupWithViewPager(viewpager)
    }
}