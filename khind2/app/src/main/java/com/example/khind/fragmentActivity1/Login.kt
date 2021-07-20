package com.example.khind.fragmentActivity1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.khind.PASSWORD
import com.example.khind.PREFERENCE_NAME
import com.example.khind.R
import com.example.khind.ShareRef.ShareReference
import com.example.khind.USERNAME
import com.example.khind.ViewModels.ActivityViewModel


class Login : Fragment() {
    lateinit var forgotpassword: TextView
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var login: Button
    lateinit var Username: String
    lateinit var Password: String
    lateinit var LoginViewModel: ActivityViewModel
    val ShareReference by lazy { ShareReference(requireContext()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username = view.findViewById(R.id.username)
        password = view.findViewById(R.id.input_password)
        forgotpassword = view.findViewById(R.id.forgot_password)
        login = view.findViewById(R.id.login)
        forgotpassword.setOnClickListener{
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_id, ForgotPassword())
            fragmentTransaction?.addToBackStack("Login")
            fragmentTransaction?.commit()
        }
        login.setOnClickListener {
            Username = username.text.toString()
            Password = password.text.toString()
            LoginViewModel.signinViewModelObserve(Username,Password)!!.observe(viewLifecycleOwner, Observer {
                if (it.statusLogin == true){
                    ShareReference.putToken(it.data.token.tokenUse,it.data.token.refresh_token)
                    val fragmentTransaction= fragmentManager?.beginTransaction()
                    fragmentTransaction?.replace(R.id.frame_layout_id, LoginSuccess())
                    fragmentTransaction?.addToBackStack(null)
                    fragmentTransaction?.commit()
                }else {
                    Toast.makeText(context, "Invalid Username", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}