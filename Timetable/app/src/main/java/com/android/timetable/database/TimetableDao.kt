package com.android.timetable.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.room.Update
import androidx.room.Delete


@Dao
interface TimetableDao {
    @Query("SELECT * FROM subject WHERE dayOfWeek=(:day) ORDER BY id ASC")
    fun getAllFromDay(day: Int): LiveData<List<Subject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(subject: Subject?)

    @Update
    suspend fun update(subject: Subject?)

    @Delete
    suspend fun delete(subject: Subject?)
}

