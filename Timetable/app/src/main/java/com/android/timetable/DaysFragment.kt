package com.android.timetable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_days.view.*


class DaysFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_days, container, false)
        view.monday_cardview.setOnClickListener {
            val action = DaysFragmentDirections.actionDaysFragmentToTimetableFragment(1)
            findNavController().navigate(action)
        }
        view.tuesday_cardview.setOnClickListener {
            val action = DaysFragmentDirections.actionDaysFragmentToTimetableFragment(2)
            findNavController().navigate(action)
        }
        view.wednesday_cardview.setOnClickListener {
            val action = DaysFragmentDirections.actionDaysFragmentToTimetableFragment(3)
            findNavController().navigate(action)
        }
        view.thursday_cardview.setOnClickListener {
            val action = DaysFragmentDirections.actionDaysFragmentToTimetableFragment(4)
            findNavController().navigate(action)
        }
        view.friday_cardview.setOnClickListener {
            val action = DaysFragmentDirections.actionDaysFragmentToTimetableFragment(5)
            findNavController().navigate(action)
        }
        view.saturday_cardview.setOnClickListener {
            val action = DaysFragmentDirections.actionDaysFragmentToTimetableFragment(6)
            findNavController().navigate(action)
        }
        return view
    }

}