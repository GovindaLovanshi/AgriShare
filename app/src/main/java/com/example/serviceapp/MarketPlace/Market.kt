package com.example.serviceapp.MarketPlace

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.serviceapp.R
import com.example.serviceapp.navigation.Routes

@Preview
@Composable
fun Market(navHostController: NavHostController){

    Scaffold (
        topBar = {
            TopBarMar()
        },
        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    navHostController.navigate(Routes.JobForm)

                },
                modifier = Modifier.size(65.dp),
                contentColor = Color.White,
            ) {

                Icon(painter = painterResource(id = R.drawable.btn_1),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp))
            }
        }

    ){ paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.white))
                .padding(paddingValues)
        ) {
            item {
                ItemList()

            }

        }

    }
}

@Composable
@Preview
fun TopBarMar(title: String = "title", onBackClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = colorResource(R.color.teal_700))
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .clickable {onBackClick() })

            Text(
                text = " Market Place",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Image(painter = painterResource(R.drawable.search)
                , contentDescription = null)
        }
    }
}