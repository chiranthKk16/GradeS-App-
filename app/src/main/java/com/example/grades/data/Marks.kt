package com.example.grades.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.security.auth.Subject

@Entity(tableName ="marks_table")
data class Marks(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "Subject") val Subject: String,
    @ColumnInfo(name = "isSub")val isSub: Int,
    @ColumnInfo(name = "isLab")val isLab: Int,
    @ColumnInfo(name = "credits") val credits: String,
    @ColumnInfo(name = "MTest1") var MTest1: Int,
    @ColumnInfo(name = "MTest2") val MTest2: Int,
    @ColumnInfo(name = "MAssgn") val MAssgn: Int,
    @ColumnInfo(name = "MLab") val MLab: Int,
    val cie: Int,
    val MFinal: Int,
    val grade: String,
    val gPoint: Int

)

@Entity
data class MarksTest1(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val Subject: String,
    val isSub: Int,
    var MTest1: Int
)

@Entity
data class MarksTest2(
    @PrimaryKey
    val id: Int,
    val Subject: String,
    val isSub: Int,
    val MTest2: Int
)

@Entity
data class MarksLab(
    @PrimaryKey
    val id: Int,
    val Subject: String,
    val isLab: Int,
    val isSub: Int,
    val MLab: Int
)

@Entity
data class MarksAssgn(
    @PrimaryKey
    val id: Int,
    val Subject: String,
    val isSub: Int,
    val MAssgn: Int
)

@Entity
data class ComputeCie(
    @PrimaryKey
    val id: Int,
    val Subject: String,
    val MTest1: Int,
    val MTest2: Int,
    val MAssgn: Int,
    val isSub: Int,
    val MLab: Int,
    val cie: Int,
)

@Entity
data class cieShow(
    @PrimaryKey
    val id: Int,
    val Subject: String,
    val isSub: Int,
    val cie: Int
)

data class finalMarks(
    @PrimaryKey
    val id: Int,
    val Subject: String,
    val isSub: Int,
    val MFinal: Int
)

data class getGPoint(
    @PrimaryKey
    val id: Int,
    val credits: String,
    val isSub: Int,
    val cie: Int,
    val MFinal: Int,
    val gPoint: Int,
    val grade: String
)