package com.example.khind.fragmentActivity2.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.khind.R
import com.example.khind.fragmentActivity2.notification.alerts.Alerts
import com.example.khind.fragmentActivity2.notification.messages.Messages
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.app_bar_home.*

class Notifications : Fragment() {
    lateinit var tablayout : TabLayout
    lateinit var  viewpager : ViewPager
    lateinit var notiBackbutton: Button

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
        activity?.toolbar1?.visibility = View.GONE
        activity?.Bottom_navigationBar?.visibility = View.GONE
        activity?.below_toolbar1?.visibility = View.GONE
        notiBackbutton = view.findViewById(R.id.backbutton_notification)
        val adapt = ViewPagerAdapter(childFragmentManager)
        tablayout = view.findViewById(R.id.tabs)
        viewpager = view.findViewById(R.id.viewPager)
        adapt.addFragment(Messages(),"Messages")
        adapt.addFragment(Alerts(),"Alerts")
        viewpager.adapter = adapt
        tablayout.setupWithViewPager(viewpager)
        notiBackbutton.setOnClickListener {
            activity?.Bottom_navigationBar?.visibility = View.VISIBLE
            activity?.toolbar1?.visibility = View.VISIBLE
            activity?.below_toolbar1?.visibility = View.VISIBLE
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Dashboard", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }

        }
    }

    override fun onResume() {
        super.onResume()
        val adapt = ViewPagerAdapter(requireFragmentManager())
        adapt.addFragment(Messages(),"Messages")
        adapt.addFragment(Alerts(),"Alerts")
        viewpager.adapter = adapt
        tablayout.setupWithViewPager(viewpager)
        notiBackbutton.setOnClickListener {
            activity?.Bottom_navigationBar?.visibility = View.VISIBLE
            activity?.toolbar1?.visibility = View.VISIBLE
            activity?.below_toolbar1?.visibility = View.VISIBLE

            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Dashboard", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}