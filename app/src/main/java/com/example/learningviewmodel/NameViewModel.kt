package com.example.learningviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.UUID

class NameViewModel : ViewModel() {
    var personList by mutableStateOf(
        listOf(
            Person(name = "Alice", hobby = "Reading"),
            Person(name = "Bob", hobby = "Painting"),
            Person(name = "Charlie", hobby = "Traveling"),
            Person(name = "David", hobby = "Cooking"),
            Person(name = "Eva", hobby = "Photography"),
            Person(name = "Frank", hobby = "Gardening"),
            Person(name = "Grace", hobby = "Cycling"),
            Person(name = "Henry", hobby = "Writing"),
            Person(name = "Ivy", hobby = "Hiking"),
            Person(name = "Jack", hobby = "Drawing")
        )
    )
        private set
    var newName by mutableStateOf("")
        private set

    var newHobby by mutableStateOf("")
        private set

    fun updateNewName(name: String) {
        newName = name
    }

    fun updateNewHobby(hobby: String) {
        newHobby = hobby
    }
//    fun updateList(name: String) {
//        namesList = namesList.plus(name)
//    }

    fun deleteLastOneFromList() {
        personList = personList.drop(1)
    }

    fun updateHobbyById(id: String?, newHobby: String) {
//        val personIndex = personList.indexOfFirst { id == it.id }
        personList = personList.map {
            if (it.id == id) {
                it.copy(hobby = newHobby)
            } else {
                it
            }
        }
    }
}

data class Person(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val hobby: String
)