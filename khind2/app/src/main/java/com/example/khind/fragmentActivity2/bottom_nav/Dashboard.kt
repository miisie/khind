package com.example.khind.fragmentActivity2.bottom_nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.khind.R
import com.example.khind.ShareRef.ShareReference
import com.example.khind.fragmentActivity2.bottom_nav.history.History
import com.example.khind.fragmentActivity2.bottom_nav.status.Status
import com.example.khind.fragmentActivity2.notification.Notifications
import com.example.khind.fragmentActivity2.school.ChooseSchool
import com.google.android.material.bottomnavigation.BottomNavigationView


class Dashboard : Fragment() {
    lateinit var notification: Button
    lateinit var school: Button
    private var check : Int = 0
    val ShareReference by lazy { ShareReference(requireContext()) }
    private lateinit var bottom_navigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottom_navigation = view.findViewById(R.id.Bottom_navigationBar)
        notification= view.findViewById(R.id.notification)
        school = view.findViewById(R.id.down_vector)
        if( check == 0) {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.add(R.id.fragment_bottom_nav, Status())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
        else if( check == 1) {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.add(R.id.fragment_bottom_nav, LightningMap())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
        else if( check == 2) {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.add(R.id.fragment_bottom_nav, History())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
        school.setOnClickListener {
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_id2, ChooseSchool())
            fragmentTransaction?.addToBackStack("Bot_Nav")
            fragmentTransaction?.commit()
        }
        notification.setOnClickListener {
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_id2, Notifications())
            fragmentTransaction?.addToBackStack("Dashboard")
            fragmentTransaction?.commit()
        }
        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.status -> {
                    check = 0
                    /*ShareReference.putBotnav("status")*/
                    val fragmentTransaction= fragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.fragment_bottom_nav, Status())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }
                R.id.lightningmap ->{
                    check = 1
                    /*ShareReference.putBotnav("lightningmap")*/
                    val fragmentTransaction= fragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.fragment_bottom_nav, LightningMap())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }
                R.id.history->{
                    check = 2
                    /*ShareReference.putBotnav("history")*/
                    val fragmentTransaction= fragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.fragment_bottom_nav, History())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }
            }
            true
        }
    }
}