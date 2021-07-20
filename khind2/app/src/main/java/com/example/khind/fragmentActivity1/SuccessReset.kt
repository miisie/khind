package com.example.khind.fragmentActivity1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.khind.R

class SuccessReset : Fragment() {
    lateinit var back_button: Button
    lateinit var reset_button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view: View = inflater.inflate(R.layout.fragment_success_reset, container, false)
        back_button = view.findViewById(R.id.btnback2)
        reset_button = view.findViewById(R.id.back_to_login)
        back_button.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("ForgotPassword", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
        reset_button.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Login", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
        return view
    }
}