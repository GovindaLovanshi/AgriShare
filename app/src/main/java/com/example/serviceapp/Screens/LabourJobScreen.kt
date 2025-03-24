package com.example.serviceapp.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.HorizontalDivider
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
import com.example.serviceapp.Models.JobModel
import com.example.serviceapp.R

@Preview
@Composable
fun LabourJobScreen(){

    val jobData = listOf(
        JobModel(
        R.drawable.cartoon,
        location = "Indore",
        jobName = "CCC2",
        description = "some work ",
        date = "16 Oct"
    ),
        JobModel(
            R.drawable.cartoon,
            location = "Indore",
            jobName = "CCC2",
            description = "some ",
            date = "16 Oct"
        ),
        JobModel(
            R.drawable.cartoon,
            location = "Indore",
            jobName = "CCC2",
            description = "some ",
            date = "16 Oct"
        ),
        JobModel(
            R.drawable.cartoon,
            location = "Indore",
            jobName = "CCC2",
            description = "some ",
            date = "16 Oct"
        ),
        JobModel(
            R.drawable.cartoon,
            location = "Indore",
            jobName = "CCC2",
            description = "some ",
            date = "16 Oct"
        ),
        JobModel(
            R.drawable.cartoon,
            location = "Indore",
            jobName = "CCC2",
            description = "some ",
            date = "16 Oct"
        ),
        JobModel(
            R.drawable.cartoon,
            location = "Indore",
            jobName = "CCC2",
            description = "some ",
            date = "16 Oct"
        ),
        JobModel(
            R.drawable.cartoon,
            location = "Indore",
            jobName = "CCC2",
            description = "some ",
            date = "16 Oct"
        ),
        JobModel(
            R.drawable.cartoon,
            location = "Indore",
            jobName = "CCC2",
            description = "some ",
            date = "16 Oct"
        ),
        JobModel(
            R.drawable.cartoon,
            location = "Indore",
            jobName = "CCC2",
            description = "some ",
            date = "16 Oct"
        ),
    )

    Scaffold(
        floatingActionButton = {

            FloatingActionButton(
                onClick = {},
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

                    IconButton(onClick = {}) {

                        Icon(
                            painter = painterResource(id = R.drawable.location),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }



            }



            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Job Pics For You",
                fontSize = 22.sp,
                color = colorResource(id = R.color.black),
                modifier = Modifier
                    .padding(start = 10.dp)
                , fontWeight = FontWeight.Bold
            )



            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {

                items(jobData) {
                    JobList(JobModel = it)
                }
            }
        }
    }

}