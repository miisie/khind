package com.example.khind.fragmentActivity2.bottom_nav

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.khind.R
import com.example.khind.ShareRef.ShareReference
import com.example.khind.ViewModels.ActivityViewModel

class Status : Fragment() {
    private lateinit var StatusViewModel: ActivityViewModel
    private lateinit var statusImage: ImageView
    private lateinit var statusText: TextView
    val ShareReference by lazy { ShareReference(requireContext()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        StatusViewModel.GetSensor(ShareReference.getToken())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*StatusViewModel.GetSensor(ShareReference.getToken())*/
        return inflater.inflate(R.layout.fragment_status, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusImage = view.findViewById(R.id.status)
        statusText = view.findViewById(R.id.inform_text)
        StatusViewModel.sensorsViewModelObserve()?.observe(viewLifecycleOwner, Observer {
            if(it.statusSensor == true){
                if(it.dataSensor[0].alarm == "clear"){
                    statusImage.setBackgroundResource(R.drawable.ic_green_status)
                    statusText.setBackgroundResource(R.drawable.inform_clear_background)
                    statusText.text = "Cloud-to-Ground no lightning detected"
                    statusText.setTextColor((Color.parseColor("#9DD31C")))
                }
                else if(it.dataSensor[0].alarm == "warning"){
                    statusImage.setBackgroundResource(R.drawable.ic_orange_status)
                    statusText.setBackgroundResource(R.drawable.inform_warning_background)
                    statusText.text = "Cloud-to-Ground lightning detected"
                    statusText.setTextColor((Color.parseColor("#FF0000")))
                }
                else if(it.dataSensor[0].alarm == "alert"){
                    statusImage.setBackgroundResource(R.drawable.ic_red_status)
                    statusText.setBackgroundResource(R.drawable.inform_alert_background)
                    statusText.text = "Cloud-to-Ground lightning detected"
                    statusText.setTextColor((Color.parseColor("#FF0000")))
                }
            }
        })
    }
}