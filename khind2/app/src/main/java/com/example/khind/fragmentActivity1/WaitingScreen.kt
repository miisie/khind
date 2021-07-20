package com.example.khind.fragmentActivity1

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khind.R
import com.example.khind.fragmentActivity1.Login


class WaitingScreen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_waiting_screen, container, false)
        val handler: Handler
        handler = Handler()
        handler.postDelayed({
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_id, Login())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }, 3000)
        return view
    }
}
