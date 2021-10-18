package com.android.timetable.database

import androidx.room.TypeConverter
import java.util.*

class TimetableDatabaseConverter {
    @TypeConverter
    fun fromDate(date: Date?): Long?{
        return date?.time
    }

    @TypeConverter
    fun toDate(milliSeconds: Long?): Date?{
        return milliSeconds?.let{
            Date(it)
        }
    }
}