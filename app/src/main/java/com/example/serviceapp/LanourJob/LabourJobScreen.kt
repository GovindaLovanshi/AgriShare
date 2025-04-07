package com.example.serviceapp.LanourJob

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.serviceapp.LanourJob.JobViewModel.jobviewmodel
import com.example.serviceapp.LanourJob.Model.JobModel
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.example.serviceapp.R
import com.example.serviceapp.navigation.Routes



@Composable
fun LabourJobScreen(navHostController: NavHostController){
    val JobViewmodel : jobviewmodel = viewModel()
    var JobList by remember { mutableStateOf<List<jobdetailsmodel>>(emptyList()) }

//    // Fetch user data
//    LaunchedEffect(true) {
//        JobViewmodel.fetchUserData(
//            onSuccess = { users ->
//                JobList = users
//            },
//            onFailure = { exception ->
//                Log.e("UserForm", "Error fetching user data: $exception")
//            }
//        )
//    }



//    LaunchedEffect(true) {
//        JobViewmodel.fetchUserData(
//            onSuccess = TODO(),
//            onFailure = TODO()
//        )
//    }

    Scaffold(
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
    ) {

        Column (modifier = Modifier.padding(it)){

            Spacer(modifier = Modifier.height(16.dp))
            
            Box(modifier = Modifier.fillMaxWidth()){

                Text(text = "Job Section",
                    fontSize = 28.sp,
                    color = colorResource(id = R.color.green),
                    modifier = Modifier.
                    align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                        , fontWeight = FontWeight.Bold
                )


                Row (modifier = Modifier.align(Alignment.CenterEnd)){
                    
                    
                    IconButton(onClick = {}) {

                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                }



            }



            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(16.dp))
//
//            Text(text = "Job Pics For You",
//                fontSize = 22.sp,
//                color = colorResource(id = R.color.black),
//                modifier = Modifier
//                    .padding(start = 10.dp)
//                , fontWeight = FontWeight.Bold
//            )



            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {

                items(JobList) { data->
                    JobList(JobModel = data, onClick = {
                        navHostController.navigate(Routes.JobDetailsScreen)
                    })

                }
            }
        }
    }

}


@Composable
fun JobList(
    JobModel: jobdetailsmodel,
    onClick: () -> Unit

){
    val context = LocalContext.current
    val JobViewmodel : jobviewmodel = viewModel()


    Row (
        modifier = Modifier.padding(8.dp).clickable {



        }, verticalAlignment = Alignment.CenterVertically
    ){

        Image(painter = painterResource(R.drawable.cartoon),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.height(12.dp))


        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 8.dp)
                .clickable {

                },
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            Text(
                text = JobModel.title,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
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
            Text(
                text = JobModel.call,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1
            )
            Text(
                text = "Date: ${JobModel.date}",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1
            )
        }
    }

    HorizontalDivider()
}

@Preview
@Composable
fun TopBarJob (){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
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
                    .clickable { })

            Text(
                text = " Job Details",
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