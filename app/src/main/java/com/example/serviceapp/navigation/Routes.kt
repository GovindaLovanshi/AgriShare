package com.example.serviceapp.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

     @Serializable
     data object SplashScreen:Routes()

    @Serializable
    data object Intro:Routes()

    @Serializable
    data object HomeScreen:Routes()


    @Serializable
    data object LabourJobScreen:Routes()

    @Serializable
    data object Market:Routes()

    @Serializable
    data object RegistrationScreen:Routes()

    @Serializable
    data object Profile:Routes()

    @Serializable
    data object JobForm:Routes()

    @Serializable
    data object TopBar:Routes()
}