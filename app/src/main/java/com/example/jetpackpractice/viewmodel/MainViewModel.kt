package com.example.jetpackpractice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val counter = MutableLiveData(0)

    fun add() {
        val currentVal = counter.value ?: 0
        counter.postValue(currentVal + 1)
    }

    fun sub() {
        val currentVal = counter.value ?: 0
        counter.postValue(currentVal - 1)
    }
}