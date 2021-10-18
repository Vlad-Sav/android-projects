package com.android.timetable

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.timetable.database.Subject
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var viewModel: TimetableViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        viewModel = ViewModelProviders.of(this).get(TimetableViewModel::class.java)
        viewModel.dayOfWeek = args.dayOfWeek

        view.update_class_title_et.setText(args.currentSubject.title)
        view.update_class_number_et.setText(args.currentSubject.id.toString())

        view.update_button.setOnClickListener {
            update()
        }

        setHasOptionsMenu(true)

        return view
    }

    fun update(){
        val classNum = Integer.parseInt(update_class_number_et.text.toString())
        val classTitle = update_class_title_et.text.toString()
        val updatedSubject = Subject(args.currentSubject.index, viewModel.dayOfWeek, classNum, classTitle)
        viewModel.update(updatedSubject)
        Toast.makeText(requireContext(), "Updated", Toast.LENGTH_SHORT).show()
        val action = UpdateFragmentDirections.actionUpdateFragmentToTimetableFragment(viewModel.dayOfWeek)
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteSubject()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteSubject() {
        val deleteAlert = AlertDialog.Builder(requireContext())
        deleteAlert.setTitle("Delete ${args.currentSubject.title}?")
        deleteAlert.setPositiveButton("Yes"){_, _ ->
            viewModel.delete(args.currentSubject)
            Toast.makeText(requireContext(), "Deleted", Toast.LENGTH_SHORT).show()
            val action = UpdateFragmentDirections.actionUpdateFragmentToTimetableFragment(viewModel.dayOfWeek)
            findNavController().navigate(action)
        }
        deleteAlert.setNegativeButton("No"){_, _ ->}
        deleteAlert.show()
    }
}