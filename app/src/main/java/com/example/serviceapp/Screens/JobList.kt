package com.example.serviceapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.serviceapp.Models.JobModel


@Composable
fun JobList(
    JobModel:JobModel
){


    Row (
        modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ){

        Image(painter = painterResource(id = JobModel.image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.height(12.dp))


        Column {

          Row(modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween){


              Text(text = JobModel.jobName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
              Text(text = JobModel.location, color = Color.Black)

          }

            Spacer(modifier = Modifier.height(4.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){


                Text(text = JobModel.description, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = JobModel.date, color = Color.Black)

            }
        }
    }

    HorizontalDivider()
}