package com.example.serviceapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.serviceapp.Screens.HomeScreen
import com.example.serviceapp.Screens.Intro
import com.example.serviceapp.Screens.LabourJobScreen
import com.example.serviceapp.Screens.RegistrationScreen
import com.example.serviceapp.Screens.SplashScreen


@Composable
fun Navigation(){

    val navController =  rememberNavController()

    NavHost(startDestination = Routes.SplashScreen, navController = navController){


        composable<Routes.SplashScreen> {

            SplashScreen(navController)
        }

        composable<Routes.Intro> {

            Intro (navController)
        }

        composable<Routes.RegistrationScreen> {

            RegistrationScreen(
                navController,
                phoneAuthViewModel = TODO()
            )
        }

        composable<Routes.HomeScreen> {

            HomeScreen()
        }

        composable<Routes.LabourJobScreen> {

            LabourJobScreen()
        }
    }
}