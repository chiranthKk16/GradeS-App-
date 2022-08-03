package com.example.grades.data

import androidx.lifecycle.LiveData

class MarksRepository(private val marksDao: MarksDao) {

    fun addMarks(marks: Marks){
        marksDao.addData(marks)
    }

    val getFirstTestMarks: LiveData<List<MarksTest1>> = marksDao.getFirstTestMarks()
    val getLabMarks: LiveData<List<MarksLab>> = marksDao.getLabMarks()
    val getSecondTestMarks: LiveData<List<MarksTest2>> = marksDao.getSecondTestMarks()
    val getAssgnMarks: LiveData<List<MarksAssgn>> = marksDao.getAssgnMarks()
    val getCieData: LiveData<List<ComputeCie>> = marksDao.getCieData()
    val showCieData: LiveData<List<cieShow>> = marksDao.showCieData()
    val getFinalMarks: LiveData<List<finalMarks>> = marksDao.getFinalMarks()
    val getGPoint: LiveData<List<getGPoint>> = marksDao.getGpaData()

    fun updateTest1(marks: MarksTest1){
        marksDao.updateTest1(marks)
    }

    fun updateTest2(marks: MarksTest2){
        marksDao.updateTest2(marks)
    }

    fun updateAssgn(marks: MarksAssgn){
        marksDao.updateAssgn(marks)
    }

    fun updateLab(marks: MarksLab){
        marksDao.updateLab(marks)
    }

    fun updateCie(marks: ComputeCie){
        marksDao.updateCie(marks)
    }

    fun updateFinalMarks(marks: finalMarks){
        marksDao.updateFinalMarks(marks)
    }

    fun updateGpa(marks: getGPoint){
        marksDao.updateGpa(marks)
    }

    fun deleteAllData(){
        marksDao.deleteAllData()
    }
}