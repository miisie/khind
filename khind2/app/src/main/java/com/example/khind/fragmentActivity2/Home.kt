package com.example.khind.fragmentActivity2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.khind.R
import com.example.khind.ShareRef.ShareReference
import com.example.khind.fragmentActivity2.nav_drawer.DashboardFragment
import com.example.khind.fragmentActivity2.nav_drawer.myprofileFragement.MyProfileFragment
import com.example.khind.fragmentActivity2.notification.Notifications
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_home.*


class Home : Fragment() {
    lateinit var notification: Button
    /*lateinit var school: Button*/
    private var check : Int = 0

    lateinit var toogle: ActionBarDrawerToggle
    lateinit var navigationView: NavigationView
    lateinit var drawer: DrawerLayout
    lateinit var toolbarTitle: TextView

    /*private lateinit var bottom_navigation : BottomNavigationView*/

   /* lateinit var DashboardViewModel: ActivityViewModel*/
    val ShareReference by lazy { ShareReference(requireContext()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*DashboardViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)*/

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       /* bottom_navigation = view.findViewById(R.id.Bottom_navigationBar)
        school = view.findViewById(R.id.down_vector)*/
        notification= view.findViewById(R.id.notification)

        //drawer
        navigationView = view.findViewById(R.id.nav_view)
        drawer = view.findViewById(R.id.drawerLayout)
        toolbarTitle =view.findViewById(R.id.title)

        if( check == 0) {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.add(R.id.frame_layout_drawer, DashboardFragment())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
        else if( check == 1) {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.add(R.id.frame_layout_drawer, Notifications())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
        else if( check == 2) {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.add(R.id.frame_layout_drawer, MyProfileFragment())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
        /*school.setOnClickListener {
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_id2, ChooseSchool())
            fragmentTransaction?.addToBackStack("Bot_Nav")
            fragmentTransaction?.commit()
        }*/
        notification.setOnClickListener {
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_id2, Notifications())
            fragmentTransaction?.addToBackStack("Dashboard")
            fragmentTransaction?.commit()
        }
        /*bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.status -> {
                    check = 0
                    val fragmentTransaction= fragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.fragment_bottom_nav, Status())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }
                R.id.lightningmap ->{
                    check = 1
                    val fragmentTransaction= fragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.fragment_bottom_nav, LightningMap())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }
                R.id.history->{
                    check = 2
                    val fragmentTransaction= fragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.fragment_bottom_nav, History())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }
            }
            true
        }*/



        // setting up navigation drawer
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        toogle = ActionBarDrawerToggle((activity as AppCompatActivity?),drawer,R.string.open,R.string.close)
        toogle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(toogle)
        toogle.syncState()

        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowTitleEnabled(false)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.DashBoard -> {
                    check = 0
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frame_layout_drawer,DashboardFragment())
                        addToBackStack(null)
                        commit()
                    }
                    navigationView.visibility = View.GONE

                }
                R.id.Notifications -> {
                    check = 1
                    Toast.makeText(this.context,"Selected Notification",Toast.LENGTH_LONG).show()
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frame_layout_id2,Notifications())
                        addToBackStack("Dashboard")
                        commit()
                    }
                    navigationView.visibility = View.GONE
                }
                R.id.MyProfile -> {
                    check = 2
                    toolbarTitle.text = "My Profile"
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frame_layout_drawer, MyProfileFragment())
                        addToBackStack(null)
                        commit()
                    }
                    navigationView.visibility = View.GONE
                }
                R.id.Settings ->{
                    check = 3
                }
                R.id.Support -> {
                    check = 4
                }
            }
            true
        }


        //refresh
       /* DashboardViewModel.sensorsViewModelObserve(ShareReference.getToken())?.observe(viewLifecycleOwner, Observer {
            Log.d("status", "${it.statusSensor}")
            if(it.statusSensor == false){
                Toast.makeText(this.context,"Invalid Token",Toast.LENGTH_LONG).show()
            }
        })*/

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
//        when(item.itemId) {
//            R.id.home -> {
//                drawer.openDrawer(GravityCompat.START)
//                return true
//            }
//        }
        return super.onOptionsItemSelected(item)
    }
}