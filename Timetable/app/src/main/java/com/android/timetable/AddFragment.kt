package com.android.timetable

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.timetable.database.Subject
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
    private lateinit var viewModel: TimetableViewModel
    private val args by navArgs<AddFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        viewModel = ViewModelProviders.of(this).get(TimetableViewModel::class.java)
        viewModel.dayOfWeek = args.dayOfWeek

        view.add_button.setOnClickListener{
            insertToDataBase()
        }

        return view
    }

    private fun insertToDataBase() {
        val classNum = Integer.parseInt(class_number_et.text.toString())
        val classTitle = class_title_et.text.toString()
        if(!TextUtils.isEmpty(classTitle)){
            val subject = Subject(0, viewModel.dayOfWeek, classNum, classTitle)
            viewModel.insert(subject)
            Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
            val action = AddFragmentDirections.actionAddFragmentToTimetableFragment(viewModel.dayOfWeek)
            findNavController().navigate(action)
        }else{
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        }
    }

}