package com.android.timetable

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_timetable.view.*


class TimetableFragment : Fragment() {
    private val args by navArgs<TimetableFragmentArgs>()
    private lateinit var timetableViewModel: TimetableViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_timetable, container, false)
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        timetableViewModel = ViewModelProviders.of(this).get(TimetableViewModel::class.java)
        timetableViewModel.dayOfWeek = args.dayOfWeek
        timetableViewModel.fillSubjects()
        timetableViewModel.subjects.observe(viewLifecycleOwner, Observer { subject ->
            adapter.setData(subject)
        })

        view.floatingActionButton.setOnClickListener{
            val action = TimetableFragmentDirections.actionTimetableFragmentToAddFragment(timetableViewModel.dayOfWeek)
            findNavController().navigate(action)
        }
        return view
    }


}