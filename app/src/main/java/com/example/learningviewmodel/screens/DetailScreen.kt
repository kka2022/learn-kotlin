package com.example.learningviewmodel.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.learningviewmodel.NameViewModel

@Composable
fun DetailScreen(navController: NavHostController, nameViewModel: NameViewModel) {
    Text(text = "Detail Screen")
}