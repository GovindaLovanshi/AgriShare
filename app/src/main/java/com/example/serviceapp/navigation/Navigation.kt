package com.example.serviceapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.serviceapp.Equipment.EquipmentDetails
import com.example.serviceapp.Equipment.listequipment
import com.example.serviceapp.Forms.EquipmentForm
import com.example.serviceapp.LanourJob.JobDetailsScreen
import com.example.serviceapp.LanourJob.JobForm
import com.example.serviceapp.LanourJob.JobList
import com.example.serviceapp.Screens.HomeScreen
import com.example.serviceapp.Screens.Intro
import com.example.serviceapp.LanourJob.LabourJobScreen
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.example.serviceapp.MarketPlace.Market
import com.example.serviceapp.Screens.Profile
import com.example.serviceapp.Screens.RegistrationScreen
import com.example.serviceapp.Screens.SettingScreen
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
                navController
            )
        }

        composable<Routes.HomeScreen> {

            HomeScreen(navController)
        }

        composable<Routes.LabourJobScreen> {

            LabourJobScreen(navController)
        }
        composable<Routes.JobForm> {

           JobForm(navController)
        }

        composable<Routes.Market> {

            Market(navController)
        }

        composable<Routes.TopBar> {

           TopBar(navController)
        }





        composable<Routes.SettingScreen> {

            SettingScreen(navController)
        }

        composable<Routes.EquipmentForm> {

            EquipmentForm(navController)
        }

        composable<Routes.listequipment> {

            listequipment(navController)
        }

        composable<Routes.EquipmentDetails> {
            EquipmentDetails(navController)
        }


        composable<Routes.Profile> {


            Profile(
                navController

            )
        }
    }
}