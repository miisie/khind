package com.example.khind.fragmentActivity2.notification.alerts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.khind.R
import com.example.khind.fragmentActivity2.notification.messages.Model

class AlertsAdapter(var mycontext: Context, var resources: Int, var items: List<ModelAlerts>): ArrayAdapter<ModelAlerts>(mycontext,resources,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mycontext)
        val view: View = layoutInflater.inflate(resources,null)
        val time: TextView = view.findViewById(R.id.time_alerts)
        val maintext: TextView = view.findViewById(R.id.mess_alerts)
        val subtext: TextView = view.findViewById(R.id.submess_alerts)
        val myItem: ModelAlerts = items[position]
        time.text = myItem.time
        maintext.text = myItem.main_text
        subtext.text = myItem.sub_text
        return view
    }
}