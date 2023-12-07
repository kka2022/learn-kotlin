package com.example.learningviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ClickViewModel : ViewModel() {
    var clickTimes by mutableStateOf(0)
        private set

    fun incrementClickTimes() {
        clickTimes++
    }
}