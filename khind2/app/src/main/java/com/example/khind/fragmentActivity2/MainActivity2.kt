package com.example.khind.fragmentActivity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.khind.R
import com.example.khind.fragmentActivity2.bottom_nav.LightningMap
import com.example.khind.fragmentActivity2.bottom_nav.history.History
import com.example.khind.fragmentActivity2.bottom_nav.Status
import com.example.khind.fragmentActivity2.nav_drawer.settingsFragment.SettingsFragment
import com.example.khind.fragmentActivity2.nav_drawer.SupportFragment
import com.example.khind.fragmentActivity2.nav_drawer.myprofileFragement.MyProfileFragment
import com.example.khind.fragmentActivity2.notification.Notifications
import com.example.khind.fragmentActivity2.school.ChooseSchool
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_home.*

class MainActivity2 : AppCompatActivity() {
    lateinit var notification: Button
    private lateinit var headline: Button
    lateinit var school: Button
    private var check : Int = 0
    private var check2 : Int = 0
    private lateinit var bottom_navigation : BottomNavigationView

    private lateinit var navigationView: NavigationView
    private lateinit var drawer: DrawerLayout
    private lateinit var toolbarTitle: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        notification=findViewById(R.id.notification)
        bottom_navigation = findViewById(R.id.Bottom_navigationBar)
        headline = findViewById(R.id.headline)
        school = findViewById(R.id.down_vector)


        supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.frame_layout_drawer, Status())
            addToBackStack(null)
            commit()
        }
        school.setOnClickListener {
            toolbar1.visibility = GONE
            Bottom_navigationBar.visibility = GONE
            below_toolbar1.visibility = GONE
            supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_layout_drawer, ChooseSchool())
                addToBackStack("before school")
                commit()
            }
        }

        //drawer
        navigationView =findViewById(R.id.nav_view)
        drawer = findViewById(R.id.drawerLayout)
        toolbarTitle =findViewById(R.id.title)

        notification.setOnClickListener {
            drawer.closeDrawer(GravityCompat.START)
                    val fragmentTransaction= supportFragmentManager.beginTransaction()
                    fragmentTransaction?.replace(R.id.frame_layout_drawer, Notifications())
                    fragmentTransaction?.addToBackStack("Dashboard")
                    fragmentTransaction?.commit()
        }
        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.status -> {
                    check = 0
                    val fragmentTransaction= supportFragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.frame_layout_drawer, Status())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }
                R.id.lightningmap ->{
                    check = 1
                    val fragmentTransaction= supportFragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.frame_layout_drawer, LightningMap())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }
                R.id.history->{
                    check = 2
                    val fragmentTransaction= supportFragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.frame_layout_drawer, History())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }
            }
            true
        }


        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.DashBoard -> {
                    toolbar1.visibility = VISIBLE
                    Bottom_navigationBar.visibility = VISIBLE
                    below_toolbar1.visibility = VISIBLE
                    drawer.closeDrawer(GravityCompat.START)
                    if(check == 0) {
                        supportFragmentManager?.beginTransaction()?.apply {
                            replace(R.id.frame_layout_drawer, Status())
                            addToBackStack(null)
                            commit()
                        }
                    }
                    else if(check == 1) {
                        supportFragmentManager?.beginTransaction()?.apply {
                            replace(R.id.frame_layout_drawer, LightningMap())
                            addToBackStack(null)
                            commit()
                        }
                    }
                    else if(check == 2) {
                        supportFragmentManager?.beginTransaction()?.apply {
                            replace(R.id.frame_layout_drawer, History())
                            addToBackStack(null)
                            commit()
                        }
                    }
                }
                R.id.Notifications -> {
                    drawer.closeDrawer(GravityCompat.START)
                    supportFragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frame_layout_drawer,Notifications())
                        addToBackStack("Dashboard")
                        commit()
                    }
                }
                R.id.MyProfile -> {
                    drawer.closeDrawer(GravityCompat.START)
                    toolbarTitle.text = "My Profile"
                    supportFragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frame_layout_drawer, MyProfileFragment())
                        addToBackStack(null)
                        commit()
                    }
                }
                R.id.Settings ->{
                    drawer.closeDrawer(GravityCompat.START)
                    toolbarTitle.text = "Settings"
                    supportFragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frame_layout_drawer, SettingsFragment())
                        addToBackStack(null)
                        commit()
                    }
                }
                R.id.Support -> {
                    drawer.closeDrawer(GravityCompat.START)
                    supportFragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frame_layout_drawer, SupportFragment())
                        addToBackStack("Support")
                        commit()
                    }
                }
            }
            true
        }
        headline.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }
    }
}