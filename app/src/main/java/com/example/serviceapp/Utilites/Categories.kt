package com.example.serviceapp.Utilites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.serviceapp.R

@Preview
@Composable
    fun Categories() {
        Row(modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)) {

            Text(
                text = "Labour Job", color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "See all",
                fontWeight = FontWeight.SemiBold,
                color = Color(android.graphics.Color.parseColor("#2e3d6d")),
                fontSize = 16.sp
            )
        }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 24.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.location), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            androidx.compose.material.Text(
                text = "Calender",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color(android.graphics.Color.parseColor("#2e3d6d"))
            )
        }
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.location), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            androidx.compose.material.Text(
                text = "Tips",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color(android.graphics.Color.parseColor("#2e3d6d"))
            )
        }
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.location), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            androidx.compose.material.Text(
                text = "Settings",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color(android.graphics.Color.parseColor("#2e3d6d"))
            )
        }
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.location), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 32.dp)
            )
            androidx.compose.material.Text(
                text = "More",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color(android.graphics.Color.parseColor("#2e3d6d"))
            )
        }


    }
        }
