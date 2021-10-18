package com.android.timetable

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.timetable.database.Subject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.DayOfWeek

class TimetableViewModel() : ViewModel() {
    var dayOfWeek: Int = 0
    val timetableRepository = TimetableRepository.get()
    lateinit var subjects: LiveData<List<Subject>>

    fun insert(subject: Subject){
        viewModelScope.launch(Dispatchers.IO){
            timetableRepository.insert(subject)
        }
    }

    fun update(subject: Subject){
        viewModelScope.launch(Dispatchers.IO){
            timetableRepository.update(subject)
        }
    }

    fun delete(subject: Subject){
        viewModelScope.launch(Dispatchers.IO){
            timetableRepository.delete(subject)
        }
    }

    fun fillSubjects(){
        subjects = timetableRepository.getSubjects(dayOfWeek)
    }
}