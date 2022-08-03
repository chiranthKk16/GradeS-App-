package com.example.grades.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MarksDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addData(marks: Marks)

    @Query("SELECT id, Subject, isSub, MTest1 FROM marks_table ORDER BY id")
    fun getFirstTestMarks(): LiveData<List<MarksTest1>>

    @Query("SELECT id, Subject, isSub, MTest2 FROM marks_table ORDER BY id")
    fun getSecondTestMarks(): LiveData<List<MarksTest2>>

    @Query("SELECT id, Subject, isLab, isSub, MLab FROM marks_table ORDER BY id")
    fun getLabMarks(): LiveData<List<MarksLab>>

    @Query("SELECT id, Subject, isSub, MAssgn FROM marks_table ORDER BY id")
    fun getAssgnMarks(): LiveData<List<MarksAssgn>>

    @Query("SELECT id, Subject, MTest1, MTest2, MAssgn, isSub, MLab, cie FROM marks_table ORDER BY id")
    fun getCieData(): LiveData<List<ComputeCie>>

    @Query("SELECT id, credits, isSub, cie, MFinal, grade, gPoint FROM marks_table ORDER BY id")
    fun getGpaData(): LiveData<List<getGPoint>>

    @Query("SELECT id, Subject, isSub, MFinal FROM marks_table ORDER BY id")
    fun getFinalMarks(): LiveData<List<finalMarks>>

    @Query("SELECT id, Subject,isSub, cie FROM marks_table ORDER BY id")
    fun showCieData(): LiveData<List<cieShow>>

    @Update(onConflict = OnConflictStrategy.IGNORE, entity = Marks::class)
    fun updateTest1(marks: MarksTest1)

    @Update(onConflict = OnConflictStrategy.IGNORE, entity = Marks::class)
    fun updateTest2(marks: MarksTest2)

    @Update(onConflict = OnConflictStrategy.IGNORE, entity = Marks::class)
    fun updateAssgn(marks: MarksAssgn)

    @Update(onConflict = OnConflictStrategy.IGNORE, entity = Marks::class)
    fun updateLab(marks: MarksLab)

    @Update(onConflict = OnConflictStrategy.IGNORE, entity = Marks::class)
    fun updateCie(marks: ComputeCie)

    @Update(onConflict = OnConflictStrategy.IGNORE, entity = Marks::class)
    fun updateFinalMarks(marks: finalMarks)

    @Update(onConflict = OnConflictStrategy.IGNORE, entity = Marks::class)
    fun updateGpa(marks: getGPoint)

    @Query("DELETE FROM marks_table")
    fun deleteAllData()

    @Query("UPDATE marks_table SET MTest1 = :marks WHERE id = :id")
    fun updateFirstMarks(marks: Int, id: Int)

}