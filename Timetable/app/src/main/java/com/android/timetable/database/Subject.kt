package com.android.timetable.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*
@Parcelize
@Entity
data class Subject(
    @PrimaryKey(autoGenerate = true) val index: Int,
    val dayOfWeek: Int,
    val id: Int,
    val title: String
    ): Parcelable {
}