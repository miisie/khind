package com.example.khind.fragmentActivity2.school

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.khind.R
import com.example.khind.ShareRef.ShareReference
import com.example.khind.fragmentActivity2.bottom_nav.Status
import com.example.khind.fragmentActivity2.bottom_nav.history.History
import kotlinx.android.synthetic.main.app_bar_home.*


class ChooseSchool : Fragment() {
    private lateinit var backbutton: Button
   /* val ShareReference by lazy { ShareReference(requireContext()) }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_school, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backbutton = view.findViewById(R.id.down_vector)
        backbutton.setOnClickListener{
            activity?.toolbar1?.visibility = View.VISIBLE
            activity?.Bottom_navigationBar?.visibility = View.VISIBLE
            activity?.below_toolbar1?.visibility = View.VISIBLE
            val fragmentTransaction= fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.frame_layout_drawer, Status())
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
    }
}