package com.example.khind.fragmentActivity2.nav_drawer.myprofileFragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.khind.R


class MyProfileFragment : Fragment() {
    lateinit var change_password_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        change_password_button = view.findViewById(R.id.changePass_button)
        change_password_button.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_layout_id2, ChangePasswordFragment())
                addToBackStack("profile")
                commit()
            }
        }
    }
}