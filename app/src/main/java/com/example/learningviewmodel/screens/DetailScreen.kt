package com.example.learningviewmodel.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.learningviewmodel.NameViewModel

@Composable
fun DetailScreen(navController: NavHostController, nameViewModel: NameViewModel, name: String?) {
    Column {
        if (name != null) {
            Text(text = name)
        }

        // Button to navigate back
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Go back")
        }
    }
}