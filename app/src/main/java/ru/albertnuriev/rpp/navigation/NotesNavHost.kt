package ru.albertnuriev.rpp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.albertnuriev.rpp.screens.*

sealed class NavRoute(val route: String) {
    object Start: NavRoute ("start_screen")
    object FirstTask: NavRoute ("first_screen")
    object SecondTask: NavRoute ("second_screen")
    object ThirdTask: NavRoute ("third_screen")
    object FourthTask: NavRoute ("fourth_screen")
    object FifthTask: NavRoute ("fifth_screen")
    object Inf: NavRoute ("inf_screen")
}

@Composable
fun NotesNavHost () {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) { StartScreen(navController = navController) }
        composable(NavRoute.FirstTask.route) { FirstTaskScreen(navController = navController) }
        composable(NavRoute.SecondTask.route) { SecondTaskScreen(navController = navController) }
        composable(NavRoute.ThirdTask.route) { ThirdTaskScreen(navController = navController) }
        composable(NavRoute.FourthTask.route) { FourthTaskScreen(navController = navController) }
        composable(NavRoute.FifthTask.route) { FifthTaskScreen(navController = navController) }
        composable(NavRoute.Inf.route) { InfScreen(navController = navController) }
    }
}