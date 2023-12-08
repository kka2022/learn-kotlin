package com.example.learningviewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningviewmodel.NameViewModel
import com.example.learningviewmodel.screens.DetailScreen
import com.example.learningviewmodel.screens.HomeScreen

@Composable
fun NamesNavigation(nameViewModel: NameViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController, nameViewModel)
        }
        composable("detail") {
            DetailScreen(navController, nameViewModel)
        }
    }
}