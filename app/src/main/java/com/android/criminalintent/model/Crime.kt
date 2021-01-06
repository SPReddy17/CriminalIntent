package com.android.criminalintent.model

import android.icu.text.CaseMap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


/*  add data keyword to the class definiton to make Crime a data class */
@Entity
data class Crime(@PrimaryKey val id : UUID = UUID.randomUUID(),
                 var title: String = "",
                 var date : Date = Date(),
                 var isSolved : Boolean = false)
