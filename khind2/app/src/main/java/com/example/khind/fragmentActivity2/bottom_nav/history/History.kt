package com.example.khind.fragmentActivity2.bottom_nav.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.khind.R
import com.example.khind.fragmentActivity2.notification.alerts.AlertsAdapter
import com.example.khind.fragmentActivity2.notification.alerts.ModelAlerts


class History : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listview = view?.findViewById<ListView>(R.id.listView_history)
        var list = mutableListOf<ModelHistory>()
        list.add(ModelHistory("04 Sep, 11:08AM",R.drawable.ic_tinyorange,"LIGHTNING DETECTED","More lightning detected for the last 30 mins"))
        list.add(ModelHistory("04 Sep, 11:00AM",R.drawable.ic_tinyyellow,"LIGHTNING DETECTED","Small lightning detected"))
        list.add(ModelHistory("04 Sep, 11:00AM",R.drawable.ic_tinygreen,"ALL CLEAR","No lightning detected for the last 30 mins"))
        listview?.adapter = HistoryAdapter(requireContext(),R.layout.row_history,list)
    }
}