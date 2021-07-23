package com.example.khind.fragmentActivity2.bottom_nav.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.khind.R
import com.example.khind.fragmentActivity2.notification.alerts.ModelAlerts

class HistoryAdapter(var mycontext: Context, var resources: Int, var items: List<ModelHistory>): ArrayAdapter<ModelHistory>(mycontext,resources,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mycontext)
        val view: View = layoutInflater.inflate(resources,null)
        val time: TextView = view.findViewById(R.id.time_history)
        val maintext: TextView = view.findViewById(R.id.mess_history)
        val subtext: TextView = view.findViewById(R.id.submess_history)
        val color: ImageView = view.findViewById(R.id.tiny_circle)
        val myItem: ModelHistory = items[position]
        time.text = myItem.time
        maintext.text = myItem.main_text
        subtext.text = myItem.sub_text
        color.setImageDrawable(mycontext.resources.getDrawable(myItem.img))
        return view
    }
}