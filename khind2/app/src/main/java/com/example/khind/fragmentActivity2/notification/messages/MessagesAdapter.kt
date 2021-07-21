package com.example.khind.fragmentActivity2.notification.messages


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.khind.R

class MessagesAdapter(var mycontext: Context, var resources: Int, var items: List<Model>): ArrayAdapter<Model>(mycontext,resources,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mycontext)
        val view: View = layoutInflater.inflate(resources,null)
        val time: TextView = view.findViewById(R.id.time)
        val maintext: TextView = view.findViewById(R.id.mess)
        val subtext: TextView = view.findViewById(R.id.submess)
        val myItem: Model = items[position]
        time.text = myItem.time
        maintext.text = myItem.main_text
        subtext.text = myItem.sub_text
        return view
    }
}