package com.example.khind.fragmentActivity2.bottom_nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.khind.R
import com.example.khind.ShareRef.ShareReference
import com.example.khind.ViewModels.ActivityViewModel

class Status : Fragment() {
    lateinit var StatusViewModel: ActivityViewModel

    val ShareReference by lazy { ShareReference(requireContext()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            /*StatusViewModel.sensorIDViewModelObserve(ShareReference.getToken(),ShareReference.getSensorId())?.observe(viewLifecycleOwner, Observer{
                if(it.statusSensorID == false){
                    Log.d("token 2", "${ShareReference.getToken()}")
                    Log.d("token 3", "${ShareReference.getRefeshToken()}")
                    StatusViewModel.refreshViewModelObserve(ShareReference.getToken(),ShareReference.getRefeshToken())?.observe(viewLifecycleOwner, Observer{
                        if(it.statusrefresh == true){
                            ShareReference.putToken(it.datarefresh.tokenRefresh.tokenRefreshUse,it.datarefresh.tokenRefresh.refreshTokenRefreshUse)
                            StatusViewModel.sensorsViewModelObserve(ShareReference.getToken())?.observe(viewLifecycleOwner, Observer {
                                if(it.statusSensor == true){
                                    ShareReference.putSensorId(it.dataSensor[0].idSensor)
                                    ShareReference.putAlarm(it.dataSensor[0].alarm)
                                    StatusViewModel.sensorIDViewModelObserve(ShareReference.getToken(),ShareReference.getSensorId())?.observe(viewLifecycleOwner,
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
            })*/
    }
}