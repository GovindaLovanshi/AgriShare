package com.example.serviceapp.DetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.serviceapp.R

@Preview
@Composable
fun EquipmentDetails(){
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
                    text = "Name Of Job",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(R.drawable.location), contentDescription = null)
                    Text(
                        text = "Address",
                        color = Color.Black,
                        fontSize = 12.sp,
                        maxLines = 1,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Date : 05-04-2025",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(12.dp))


                Text(
                    text = "About The Job",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )

                HorizontalDivider()
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "श्रमिक किसी भी देश की अर्थव्यवस्था की रीढ़ होते हैं। उनकी मेहनत और समर्पण से उद्योग, निर्माण और विभिन्न सेवाओं का विकास संभव होता है। मजदूरों के अधिकारों की रक्षा और उचित वेतन सुनिश्चित करना समाज की जिम्मेदारी है। हर श्रमिक का सम्मान और सुरक्षा मिलना जरूरी है, ताकि वे आत्मसम्मान और गरिमा के साथ जीवन व्यतीत कर सकें। श्रमिक किसी भी देश की अर्थव्यवस्था की रीढ़ होते हैं। उनकी मेहनत और समर्पण से उद्योग, निर्माण और विभिन्न सेवाओं का विकास संभव होता है। मजदूरों के अधिकारों की रक्षा और उचित वेतन सुनिश्चित करना समाज की जिम्मेदारी है। हर श्रमिक का सम्मान और सुरक्षा मिलना जरूरी है, ताकि वे आत्मसम्मान और गरिमा के साथ जीवन व्यतीत कर सकें।",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                )


            }
        }




    }
}