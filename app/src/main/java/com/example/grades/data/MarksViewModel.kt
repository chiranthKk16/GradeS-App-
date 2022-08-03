package com.example.grades.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MarksViewModel(application: Application): AndroidViewModel(application) {

    private val repository: MarksRepository
    val getFirstTestMarks: LiveData<List<MarksTest1>>
    val getLabMarks: LiveData<List<MarksLab>>
    val getSecondTestMarks: LiveData<List<MarksTest2>>
    val getAssgnMarks: LiveData<List<MarksAssgn>>
    val getCieData: LiveData<List<ComputeCie>>
    val showCieData: LiveData<List<cieShow>>
    val getFinalMarks: LiveData<List<finalMarks>>
    val getGPoint: LiveData<List<getGPoint>>

    init {
        val marksDao =MarksDatabase.getDatabase(application).marksDao()
        repository = MarksRepository(marksDao)
        getFirstTestMarks = repository.getFirstTestMarks
        getSecondTestMarks = repository.getSecondTestMarks
        getAssgnMarks = repository.getAssgnMarks
        getLabMarks = repository.getLabMarks
        getCieData = repository.getCieData
        showCieData = repository.showCieData
        getFinalMarks = repository.getFinalMarks
        getGPoint = repository.getGPoint
    }

    fun addData(marks: Marks){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMarks(marks)
        }
    }

    fun updateTest1(marks: MarksTest1){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTest1(marks)
        }
    }

    fun updateTest2(marks: MarksTest2){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTest2(marks)
        }
    }

    fun updateAssgn(marks: MarksAssgn){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateAssgn(marks)
        }
    }

    fun updateLab(marks: MarksLab){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLab(marks)
        }
    }

    fun updateCie(marks: ComputeCie){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCie(marks)
        }
    }

    fun updateFinalMarks(marks: finalMarks){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateFinalMarks(marks)
        }
    }

    fun updateGpa(marks: getGPoint){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateGpa(marks)
        }
    }

    fun deleteAllData(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllData()
        }
    }
}