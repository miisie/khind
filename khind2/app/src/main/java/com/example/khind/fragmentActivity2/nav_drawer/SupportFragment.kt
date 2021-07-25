package com.example.khind.fragmentActivity2.nav_drawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.khind.R
import kotlinx.android.synthetic.main.app_bar_home.*

class SupportFragment : Fragment() {
    private lateinit var button_back : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_support, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.toolbar1?.visibility = View.GONE
        activity?.Bottom_navigationBar?.visibility = View.GONE
        activity?.below_toolbar1?.visibility = View.GONE
        button_back = view.findViewById(R.id.btnbackabout)
        button_back.setOnClickListener {
            activity?.Bottom_navigationBar?.visibility = View.VISIBLE
            activity?.toolbar1?.visibility = View.VISIBLE
            activity?.below_toolbar1?.visibility = View.VISIBLE
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Support", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}