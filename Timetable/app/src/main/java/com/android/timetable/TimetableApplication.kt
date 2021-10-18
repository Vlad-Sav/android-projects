package com.android.timetable

import android.app.Application
import androidx.room.Room
import com.android.timetable.database.TimetableDatabase

class TimetableApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        TimetableRepository.initialize(this)
    }
}