package com.example.khind.fragmentActivity1

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.khind.R


class ForgotPassword : Fragment() {
    lateinit var reset: Button
    lateinit var username_reset: EditText
    lateinit var Username_reset: String
    lateinit var back_button: Button
    val string: String = "@gmail.com"
    var check: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_forgot_password,container,false)
        reset = view.findViewById(R.id.reset)
        username_reset = view.findViewById(R.id.reset_username)
        back_button = view.findViewById(R.id.btnback1)
        reset.setOnClickListener {
            Username_reset =  username_reset.text.toString()
            check = string in Username_reset

            if(check == true) {
                val fragmentTransaction = fragmentManager?.beginTransaction()
                fragmentTransaction?.replace(R.id.frame_layout_id, SuccessReset())
                fragmentTransaction?.addToBackStack("ForgotPassword")
                fragmentTransaction?.commit()
            }else {
                Toast.makeText(context, "Invalid Reset Username", Toast.LENGTH_LONG).show()
            }
        }
        back_button.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Login", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
        return view
    }
}

