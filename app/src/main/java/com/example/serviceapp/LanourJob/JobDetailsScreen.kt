package com.example.serviceapp.LanourJob


import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.serviceapp.DetailScreen.JObDetails
import com.example.serviceapp.LanourJob.JobViewModel.jobviewmodel
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.example.serviceapp.R
import com.example.serviceapp.navigation.Routes

@Preview
@Composable
fun JobDetailsScreen() {
    val JobViewModel: jobviewmodel = viewModel()
    val JobViewmodel : jobviewmodel = viewModel()
    var JobList by remember { mutableStateOf<List<jobdetailsmodel>>(emptyList()) }

    // Fetch user data
    LaunchedEffect(true) {
        JobViewmodel.fetchUserData(
            onSuccess = { users ->
                JobList = users
            },
            onFailure = { exception ->
                Log.e("UserForm", "Error fetching user data: $exception")
            }
        )
    }

    Scaffold(
        topBar = {
            TopBarJob()
        },
        bottomBar = {
            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                onClick = { /* TODO: Implement click action */ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                androidx.compose.material3.Text(
                    text = "Connect ", color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }

    ) {padding ->

        LazyColumn (modifier = Modifier.padding(padding)){

            items(JobList) { data->
                JobList(JobModel = data, onClick = {

                })

            }
        }
    }
}


@Composable
fun JObDetails(
    JobModel: jobdetailsmodel,
    onClick: () -> Unit
){

    val JobViewModel: jobviewmodel = viewModel()

    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {

        Row (modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(R.drawable.homed),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop)

            Text(
                text = "Name Of Company",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )


        }
        Row (
            modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ){



            Spacer(modifier = Modifier.height(12.dp))


            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = JobModel.title,
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




    }
}