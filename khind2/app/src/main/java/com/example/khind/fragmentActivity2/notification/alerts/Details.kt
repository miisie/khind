package com.example.khind.fragmentActivity2.notification.alerts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.khind.R
import com.example.khind.ShareRef.ShareReference
import com.example.khind.fragmentActivity2.notification.Notifications


class Details : Fragment() {
    lateinit var backdetailbutton: Button
    val ShareReference by lazy { ShareReference(requireContext()) }
    private lateinit var timeDetails: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timeDetails = view.findViewById(R.id.time_detail)
        timeDetails.text = ShareReference.getTime()
        backdetailbutton = view.findViewById(R.id.backbutton_details)
        backdetailbutton.setOnClickListener {
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_id2, Notifications())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }

    }
}