package com.android.timetable.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Subject::class], version = 1)
@TypeConverters(TimetableDatabaseConverter::class)
abstract class TimetableDatabase: RoomDatabase() {
    abstract fun timetableDao(): TimetableDao
}