package com.example.learningviewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(
            route = "detail/{id}",
            arguments = listOf(
                navArgument(name = "id",
                    builder = { type = NavType.StringType }
                )
            )
        ) { backStackEntry ->
            DetailScreen(
                navController,
                nameViewModel,
                backStackEntry.arguments?.getString("id")
            )
        }
    }
}