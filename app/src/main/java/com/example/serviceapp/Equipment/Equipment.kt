package com.example.serviceapp.Equipment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
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
fun Equipment(){

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
                painter = painterResource(id = R.drawable.tractor), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            Text(
                text = "Inbox",
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
                painter = painterResource(id = R.drawable.road), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            Text(
                text = "Maps",
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
                painter = painterResource(id = R.drawable.tractor), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            Text(
                text = "Chats",
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
                painter = painterResource(id = R.drawable.road), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            Text(
                text = "Report",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color(android.graphics.Color.parseColor("#2e3d6d"))
            )
        }
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
                painter = painterResource(id = R.drawable.tractor), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            Text(
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
                painter = painterResource(id = R.drawable.road), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            Text(
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
                painter = painterResource(id = R.drawable.tractor), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
            )
            Text(
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
                painter = painterResource(id = R.drawable.road), contentDescription = null,
                Modifier
                    .padding(top = 8.dp, bottom = 4.dp, start = 4.dp, end = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 32.dp)
            )
            Text(
                text = "More",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color(android.graphics.Color.parseColor("#2e3d6d"))
            )
        }


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
            Text(
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
            Text(
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
            Text(
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
            Text(
                text = "More",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color(android.graphics.Color.parseColor("#2e3d6d"))
            )
        }


    }

}