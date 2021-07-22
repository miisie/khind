package com.example.khind.fragmentActivity2.notification.alerts

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.khind.R
import com.example.khind.fragmentActivity2.MainActivity2
import com.example.khind.fragmentActivity2.bottom_nav.status.StatusAlert


class Alerts : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alerts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listview = view?.findViewById<ListView>(R.id.listView2)
        var list = mutableListOf<ModelAlerts>()
        list.add(ModelAlerts("04 Sep, 11:08AM","BROADCARD MESSAGE TITLE","Push notification message here is very long ..."))
        list.add(ModelAlerts("04 Sep, 11:22AM","BROADCARD MESSAGE TITLE","Push notification message"))
        listview.isClickable = true
        listview?.adapter = AlertsAdapter(requireContext(),R.layout.row_alerts,list)
        listview.setOnItemClickListener { parent, view, position, id ->

            val time = list[position].time
            val intent = Intent(requireContext(), DetailsActivity::class.java)
            intent.putExtra("time", time)
            startActivity(intent)
        }
    }
}
