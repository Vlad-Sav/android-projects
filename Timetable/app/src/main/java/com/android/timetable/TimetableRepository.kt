package com.android.timetable

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.android.timetable.database.Subject
import com.android.timetable.database.TimetableDao
import com.android.timetable.database.TimetableDatabase

private const val DATABASE_NAME = "timetable-database"

class TimetableRepository private constructor(context: Context){

    private val database: TimetableDatabase = Room.databaseBuilder(
        context.applicationContext,
        TimetableDatabase::class.java,
        DATABASE_NAME).build()

    private val dao: TimetableDao = database.timetableDao()

    fun getSubjects(day: Int): LiveData<List<Subject>> = dao.getAllFromDay(day)

    suspend fun insert(subject: Subject) = dao.insert(subject)

    suspend fun update(subject: Subject) = dao.update(subject)

    suspend fun delete(subject: Subject) = dao.delete(subject)

    companion object {
        private var INSTANCE: TimetableRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TimetableRepository(context)
            }
        }
        fun get(): TimetableRepository {
            return INSTANCE ?:
            throw IllegalStateException("Repository must be initialized")
        }
    }
}