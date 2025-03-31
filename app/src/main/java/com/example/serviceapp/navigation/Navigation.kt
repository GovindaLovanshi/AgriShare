package com.example.serviceapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.serviceapp.Forms.JobForm
import com.example.serviceapp.Screens.HomeScreen
import com.example.serviceapp.Screens.Intro
import com.example.serviceapp.LanourJob.LabourJobScreen
import com.example.serviceapp.MarketPlace.Market
import com.example.serviceapp.Screens.Profile
import com.example.serviceapp.Screens.RegistrationScreen
import com.example.serviceapp.Screens.SplashScreen
import com.example.serviceapp.Screens.TopBar


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

            HomeScreen(navController)
        }

        composable<Routes.LabourJobScreen> {

            LabourJobScreen(navController)
        }
        composable<Routes.JobForm> {

           JobForm()
        }

        composable<Routes.Market> {

            Market()
        }

        composable<Routes.TopBar> {

           TopBar(navController)
        }

//        composable<Routes.Profile> {
//
//
//            Profile(
//                navControlle
//
//            )
//        }
    }
}