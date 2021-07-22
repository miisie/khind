package com.example.khind.fragmentActivity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.khind.R
import com.example.khind.fragmentActivity2.bottom_nav.Dashboard

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        /*addFragmentToActivity(supportFragmentManager, Dashboard(), R.id.frame_layout_id2)*/
        val fragmentTransaction= supportFragmentManager.beginTransaction()
        fragmentTransaction?.add(R.id.frame_layout_id2, Dashboard())
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()

    }
   /* private fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment?, frameId: Int) {
        val transaction: FragmentTransaction = manager.beginTransaction()
        if (fragment != null) {
            transaction.add(frameId, fragment)
            transaction.addToBackStack("Dashboard")
        }
        transaction.commit()
    }*/
}