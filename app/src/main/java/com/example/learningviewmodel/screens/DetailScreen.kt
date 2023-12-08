package com.example.learningviewmodel.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learningviewmodel.NameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavHostController,
    nameViewModel: NameViewModel,
    id: String?
) {
    val newHobby = nameViewModel.newHobby
    val currentPerson = nameViewModel.personList.firstOrNull {
        it.id == id
    }
    val currentHobby = currentPerson?.hobby

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = id?.let {
                    currentPerson?.name ?: "Some Error in Name"
                } ?: "Some Error in name"
            )
            Text(text = currentHobby ?: "Some Error in Hobby ")

            TextField(
                value = newHobby,
                onValueChange = { nameViewModel.updateNewHobby(it) },
                label = { Text(text = "New Hobby") },
                modifier = Modifier.fillMaxWidth()
            )
            // Button to navigate back
            Button(onClick = {
                nameViewModel.updateHobbyById(id, newHobby)
            }) {
                Text(text = "Update Hobby")
            }
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text(text = "Go back")
            }
        }
    }
}