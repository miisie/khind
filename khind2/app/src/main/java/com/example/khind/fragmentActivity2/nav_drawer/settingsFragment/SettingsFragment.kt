package com.example.khind.fragmentActivity2.nav_drawer.settingsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import com.example.khind.R
import com.example.khind.fragmentActivity2.notification.Notifications
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {
    private lateinit var alarm_sound: SwitchCompat
    private lateinit var alarm_ringtone_text : TextView
    private lateinit var alarm_ringtone_right : Button
    private lateinit var faq_right : Button
    private lateinit var privacy_policy_right : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.Bottom_navigationBar?.visibility = View.GONE
        activity?.below_toolbar1?.visibility = View.GONE
        activity?.toolbar1?.visibility = View.VISIBLE

        privacy_policy_right = view.findViewById(R.id.privacy_policy_right)
        faq_right = view.findViewById(R.id.faq_right)
        alarm_sound = view.findViewById(R.id.switch_alarm_sound)
        alarm_ringtone_right = view.findViewById(R.id.alarm_ringtone_right)
        alarm_sound.setOnClickListener {
            if(alarm_sound.isChecked) {
                alarm_ringtone.visibility = View.VISIBLE
                switch_alarm_vibration.visibility = View.VISIBLE
                switch_setup_schedule.visibility = View.GONE
            }
            else {
                alarm_ringtone.visibility = View.GONE
                switch_alarm_vibration.visibility = View.GONE
                switch_setup_schedule.visibility = View.VISIBLE
            }
        }
        faq_right.setOnClickListener {
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_drawer, FaqFragment())
            fragmentTransaction?.addToBackStack("faq")
            fragmentTransaction?.commit()
        }
        privacy_policy_right.setOnClickListener {
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_drawer, PrivacyPolicyFragment())
            fragmentTransaction?.addToBackStack("privacy")
            fragmentTransaction?.commit()
        }
        alarm_ringtone_right.setOnClickListener {
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_drawer, RingToneFragment())
            fragmentTransaction?.addToBackStack("ringtone")
            fragmentTransaction?.commit()
        }
    }
}