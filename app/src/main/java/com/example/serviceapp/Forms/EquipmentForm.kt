package com.example.serviceapp.Forms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.serviceapp.R

@Preview
@Composable
fun EquipmentForm() {

    var text by remember { mutableStateOf("") }
    var endDate by rememberSaveable { mutableLongStateOf(0L) }
    var showDatePicker by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#EEEEFB"))),
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Row(modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)) {

            Text(
                text = "Add New Jobs", color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )


        }

        Spacer(modifier = Modifier.padding(20.dp))


        Image(painter = painterResource(R.drawable.profile),
            contentDescription = null,
            modifier = Modifier.width(50.dp).height(50.dp)
                .clip(CircleShape)
            , contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            modifier = Modifier.width(350.dp),
            value = text,
            onValueChange = {text = it},
            placeholder = { Text(text = "Name OF Job") }

        )

        Spacer(modifier = Modifier.padding(20.dp))

        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){


            TextField(
                modifier = Modifier.width(170.dp),
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = "Age") }

            )

            Spacer(modifier = Modifier.padding())

            TextField(
                modifier = Modifier.width(170.dp),
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = "Salary") }

            )



        }
        Spacer(modifier = Modifier.padding(20.dp))

        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){


            TextField(
                modifier = Modifier.width(170.dp),
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = "Address") }

            )

            Spacer(modifier = Modifier.padding())

            TextField(
                modifier = Modifier.width(170.dp),
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = "Date") }

            )



        }

        Spacer(modifier = Modifier.padding(20.dp))



        TextField(
            modifier = Modifier.width(350.dp),
            value = text,
            onValueChange = {text = it},
            placeholder = { Text(text = "Mobile Number") }

        )

        Spacer(modifier = Modifier.padding(20.dp))


        TextField(
            modifier = Modifier.width(350.dp)
                .height(150.dp),
            value = text,
            onValueChange = {text = it},
            placeholder = { Text(text = "Description") },


            )


        Spacer(modifier = Modifier.padding(40.dp))

        Button(
            modifier = Modifier.width(250.dp),
            onClick = { /* TODO: Implement click action */ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = "Add ", color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }



    }
}