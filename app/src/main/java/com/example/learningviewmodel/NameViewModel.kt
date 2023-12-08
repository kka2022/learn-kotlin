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

    fun updateList(person: Person) {
        personList = listOf(person).plus(personList)
    }

//    fun deleteLastOneFromList() {
//        personList = personList.drop(1)
//    }

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