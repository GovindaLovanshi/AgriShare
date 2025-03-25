package com.example.serviceapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.serviceapp.Utilites.Categories
import com.example.serviceapp.Utilites.Equipment
import com.example.serviceapp.Utilites.MyBottomBar
import com.example.serviceapp.Utilites.Search
import com.example.serviceapp.navigation.Routes
import com.uilover.project2222.Activity.Dashboard.TopBar


@Composable
fun HomeScreen(navHostController: NavHostController){
    Scaffold(
        bottomBar = {
            MyBottomBar(navHostController , selectedItem = 0, onClick = { index ->

                when(index){

                    0 -> {navHostController.navigate(Routes.HomeScreen)}
                    1 -> {navHostController.navigate(Routes.LabourJobScreen)}
                    2 -> {navHostController.navigate(Routes.LabourJobScreen)}
                    3 -> {navHostController.navigate(Routes.HomeScreen)}
                }

            })
        }
    ) { paddingValues ->
        LazyColumn(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(paddingValues)
                .background(color = Color(android.graphics.Color.parseColor("#f8eeec"))),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            item {
                TopBar()
            }

            item {
                Search()
            }

            item {
                Equipment()
            }

            item {
                Categories()
            }

        }
    }

}