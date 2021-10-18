package com.android.timetable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.timetable.database.Subject
import kotlinx.android.synthetic.main.timetable_list_item.view.*
import java.util.zip.Inflater


class ListAdapter: RecyclerView.Adapter<ListAdapter.SubjectHolder>() {
    private var subjectList: List<Subject> = emptyList<Subject>()

    class SubjectHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectHolder {
        return SubjectHolder(LayoutInflater.from(parent.context).inflate(R.layout.timetable_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {
        val currentItem: Subject = subjectList[position]
        holder.itemView.number_tv.text = currentItem.id.toString()
        holder.itemView.title_tv.text =  currentItem.title
        holder.itemView.list_item.setOnClickListener {
            val action = TimetableFragmentDirections.actionTimetableFragmentToUpdateFragment(currentItem, currentItem.dayOfWeek)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    fun setData(subjects: List<Subject>){
        this.subjectList = subjects
        notifyDataSetChanged()
    }
}