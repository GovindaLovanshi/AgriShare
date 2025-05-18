package com.example.serviceapp.LanourJob

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.serviceapp.LanourJob.JobViewModel.JobViewModel
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel


@Composable
fun JobForm(navHostController: NavHostController) {
    val viewModel : JobViewModel = viewModel()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()



    var title by remember { mutableStateOf("") }
    var call by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var date by remember { mutableStateOf("") }


    // Image picker
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }






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



        // Image Picker


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable { launcher.launch("image/*") }
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            if (imageUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                Text("Tap to select image")
            }
        }

        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            modifier = Modifier.width(350.dp),
            value = title,
            onValueChange = {title = it},
            placeholder = { Text(text = "Name OF Job") }

        )

        Spacer(modifier = Modifier.padding(20.dp))

        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){


            TextField(
                modifier = Modifier.width(170.dp),
                value = address,
                onValueChange = { address = it },
                placeholder = { Text(text = "Enter Location") }

            )

            Spacer(modifier = Modifier.padding())

            TextField(
                modifier = Modifier.width(170.dp),
                value = salary,
                onValueChange = { salary = it },
                placeholder = { Text(text = "Salary") }

            )





        }
        Spacer(modifier = Modifier.padding(20.dp))

        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){


            TextField(
                modifier = Modifier.width(170.dp),
                value = age,
                onValueChange = { age = it },
                placeholder = { Text(text = "Enter Age") }

            )

            Spacer(modifier = Modifier.padding())

            TextField(
                modifier = Modifier.width(170.dp),
                value = date,
                onValueChange = { date = it },
                placeholder = { Text(text = "date") }

            )





        }
        Spacer(modifier = Modifier.padding(20.dp))





        TextField(
            modifier = Modifier.width(350.dp),
            value = description,
            onValueChange = {description = it},
            placeholder = { Text(text = "Description") }

        )




        Spacer(modifier = Modifier.padding(40.dp))




        Button(
            modifier = Modifier.width(250.dp),
            onClick = {

                if (title.isNotBlank() && address.isNotBlank() && date.isNotBlank()
                    && age.isNotBlank() && call.isNotBlank()
                ) {
                    val job = jobdetailsmodel(
                        title = title,
                        age = age,
                        call = call,
                        address = address,
                        Salary = salary,
                        description = description,
                        date = date,


                        )

                    viewModel.addJob (job, imageUri,
                        onSuccess = {
                            Toast.makeText(context, "job added successfully", Toast.LENGTH_SHORT).show()
                            navHostController.popBackStack()
                        },
                        onError = {
                            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                        }
                    )
                } else {
                    Toast.makeText(context, "Please fill all fields and select image", Toast.LENGTH_SHORT).show()
                }



            },
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

