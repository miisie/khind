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
            if(fragmentManager?.backStackEntryCount!! > 0 ) {
                fragmentManager?.popBackStack("Bot_Nav", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}