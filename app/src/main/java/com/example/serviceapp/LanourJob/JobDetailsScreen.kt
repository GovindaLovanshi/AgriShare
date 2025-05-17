package com.example.serviceapp.LanourJob


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.serviceapp.DetailScreen.JObDetails
import com.example.serviceapp.LanourJob.JobViewModel.JobViewModel

import com.example.serviceapp.LanourJob.Model.JobModel
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.example.serviceapp.R
import com.example.serviceapp.navigation.Routes


@Composable
fun JobDetailsScreen(navHostController: NavHostController ){
    val JobViewmodel : JobViewModel = viewModel()
    val datalist = JobViewmodel.jobList


    LaunchedEffect(true) {
        JobViewmodel.fetchJobs()
    }
    Scaffold(
        topBar = {
            TopBarJob()
        },
        bottomBar = {

        }

    ) {padding ->

        LazyColumn (modifier = Modifier.padding(padding)){

            items(datalist) { data->
                JObDetails(data )

            }
        }
    }
}


@Composable
fun JObDetails(
    JobModel: jobdetailsmodel,

){

    val context = LocalContext.current


    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {

        Row (modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){
            AsyncImage(
                model = JobModel.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                text = JobModel.title,
                modifier = Modifier.padding(start = 20.dp),
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )


        }




            Spacer(modifier = Modifier.height(12.dp))


            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = JobModel.Salary,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(R.drawable.location), contentDescription = null)
                    Text(
                        text = JobModel.address,
                        color = Color.Black,
                        fontSize = 12.sp,
                        maxLines = 1,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = JobModel.date,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(12.dp))


                Text(
                    text = JobModel.call,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )

                HorizontalDivider()
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = JobModel.description,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                )


            }
        }

        Spacer(modifier = Modifier.height(200.dp))
        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            onClick = {


                val phoneNumber="tel:"+JobModel.call
                val diaIntent= Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
                context.startActivity(diaIntent)

            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "Connect ", color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,


            )
        }




    }
