package com.example.khind.fragmentActivity2

import android.app.Notification
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.khind.R
import com.example.khind.ShareRef.ShareReference
import com.example.khind.ViewModels.ActivityViewModel

class DashBoard : Fragment() {
    lateinit var DashBoardViewModel: ActivityViewModel
    lateinit var notification: Button
    val ShareReference by lazy { ShareReference(requireContext()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DashBoardViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notification= view.findViewById(R.id.notification)
        notification.setOnClickListener {}
            DashBoardViewModel.sensorIDViewModelObserve(ShareReference.getToken(),ShareReference.getSensorId())?.observe(viewLifecycleOwner, Observer{
                if(it.statusSensorID == false){
                    Log.d("token 2", "${ShareReference.getToken()}")
                    Log.d("token 3", "${ShareReference.getRefeshToken()}")
                    DashBoardViewModel.refreshViewModelObserve(ShareReference.getToken(),ShareReference.getRefeshToken())?.observe(viewLifecycleOwner, Observer{
                        if(it.statusrefresh == true){
                            ShareReference.putToken(it.datarefresh.tokenRefresh.tokenRefreshUse,it.datarefresh.tokenRefresh.refreshTokenRefreshUse)
                            DashBoardViewModel.sensorsViewModelObserve(ShareReference.getToken())?.observe(viewLifecycleOwner, Observer {
                                if(it.statusSensor == true){
                                    Log.d("token 4", "${ShareReference.getToken()}")
                                    ShareReference.putSensorId(it.dataSensor[0].idSensor)
                                    ShareReference.putAlarm(it.dataSensor[0].alarm)
                                    DashBoardViewModel.sensorIDViewModelObserve(ShareReference.getToken(),ShareReference.getSensorId())?.observe(viewLifecycleOwner,
                                        Observer {
                                            if(it.statusSensorID == true){
                                                ShareReference.putLatitude(it.dataSensorID.latitude.toFloat())
                                                ShareReference.putLongitude(it.dataSensorID.longitude.toFloat())
                                            }
                                        })
                                }
                            })
                        }
                    })
                }
            })
    }
}