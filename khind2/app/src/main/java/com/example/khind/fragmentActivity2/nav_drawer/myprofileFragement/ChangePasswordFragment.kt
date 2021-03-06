package com.example.khind.fragmentActivity2.nav_drawer.myprofileFragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.khind.R
import kotlinx.android.synthetic.main.app_bar_home.*


class ChangePasswordFragment : Fragment() {
    private lateinit var back_button: Button
    private lateinit var update_button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_change_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.toolbar1?.visibility = View.GONE
        super.onViewCreated(view, savedInstanceState)
        back_button = view.findViewById(R.id.btnbackprofile)
        update_button = view.findViewById(R.id.update)
        back_button.setOnClickListener {
            activity?.toolbar1?.visibility = View.VISIBLE
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("profile", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
        update_button.setOnClickListener {
            activity?.toolbar1?.visibility = View.VISIBLE
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("profile", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}