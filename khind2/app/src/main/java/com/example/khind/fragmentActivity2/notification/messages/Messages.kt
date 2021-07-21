package com.example.khind.fragmentActivity2.notification.messages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.khind.R

class Messages : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listview = view?.findViewById<ListView>(R.id.listView)
        var list = mutableListOf<Model>()
        list.add(Model("04 Sep, 11:08AM","BROADCARD MESSAGE TITLE","Push notification message"))
        listview?.adapter = MessagesAdapter(requireContext(),R.layout.row_messages,list)
    }
}