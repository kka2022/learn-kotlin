package com.example.learningviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {
    var namesList by mutableStateOf(listOf("Mohan", "Sohan", "Kabir", "Lama", "Bunty", "Sandy"))
        private set
    var newName by mutableStateOf("")
        private set

    fun updateNewName(name: String) {
        newName = name
    }
    fun updateList(name: String) {
        namesList = namesList.plus(name)
    }

    fun deleteLastOneFromList() {
        namesList = namesList.drop(1)
    }
}