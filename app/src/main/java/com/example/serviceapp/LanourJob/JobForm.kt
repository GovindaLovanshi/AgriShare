package com.example.serviceapp.LanourJob

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.serviceapp.LanourJob.JobViewModel.jobViewModel
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.example.serviceapp.navigation.Routes



@Composable
fun JobForm(navHostController: NavHostController) {

    val JobViewModel: jobViewModel = viewModel()


    var title by remember { mutableStateOf("") }
    var call by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var date by remember { mutableStateOf("") }


    val context = LocalContext.current
    val pickImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }

    // Fetch user data


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



        Button(onClick = {
           pickImage.launch("image/*")
        }) {
            Text("Select Image")
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

                    val formData = imageUri?.toString()
                        ?.let { jobdetailsmodel(title,call,address,description, imageUrl = null) }
                    JobViewModel.submitForm(formData!!)
                    Toast.makeText(context,"Data Successfully added",Toast.LENGTH_SHORT).show()
                    navHostController.navigate(Routes.LabourJobScreen)

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

