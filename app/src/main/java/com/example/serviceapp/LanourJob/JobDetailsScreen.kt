package com.example.serviceapp.LanourJob

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.serviceapp.DetailScreen.JObDetails

@Preview
@Composable
fun JobDetailsScreen() {

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

        LazyColumn(modifier = Modifier.padding(padding)) {

            item {
                JObDetails()
            }


        }
    }
}