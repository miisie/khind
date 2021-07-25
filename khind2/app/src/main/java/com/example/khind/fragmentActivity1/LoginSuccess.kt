package com.example.khind.fragmentActivity1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.khind.R
import com.example.khind.ShareRef.ShareReference
import com.example.khind.ViewModels.ActivityViewModel
import com.example.khind.fragmentActivity2.MainActivity2

class LoginSuccess : Fragment() {
    lateinit var LoginSuccessViewModel: ActivityViewModel
    val ShareReference by lazy { ShareReference(requireContext()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginSuccessViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_login_success, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val handler: Handler
        handler = Handler()
        handler.postDelayed({
            activity.let {
                var intent = Intent(it,MainActivity2::class.java)
                it?.startActivity(intent)
            }
        }, 2000)
    }
}