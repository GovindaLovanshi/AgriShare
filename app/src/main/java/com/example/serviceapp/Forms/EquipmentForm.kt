package com.example.serviceapp.Forms

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.serviceapp.Equipment.Model.EquipmentModel
import com.example.serviceapp.Equipment.Viewmodel.EquipmentViewModel
import com.example.serviceapp.LanourJob.JobViewModel.jobViewModel
import com.example.serviceapp.R
import com.example.serviceapp.navigation.Routes


@Composable
fun EquipmentForm(navHostController: NavHostController) {

    val equipmentViewModel: EquipmentViewModel = viewModel()


    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var call by remember { mutableStateOf("") }
    var ownerName by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }


    val context = LocalContext.current
    val pickImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }


    val EquipmentViewModel: EquipmentViewModel = viewModel()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#EEEEFB"))),
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Row(modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)) {

            Text(
                text = "Add New Equipments", color = Color.Black,
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
            value = title,
            onValueChange = {title = it},
            placeholder = { Text(text = "Name OF Equipment") }

        )

        Spacer(modifier = Modifier.padding(20.dp))

        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){


            TextField(
                modifier = Modifier.width(170.dp),
                value = price,
                onValueChange = { price = it },
                placeholder = { Text(text = "Price") }

            )

            Spacer(modifier = Modifier.padding())

            TextField(
                modifier = Modifier.width(170.dp),
                value = address,
                onValueChange = { address = it },
                placeholder = { Text(text = "Address") }

            )



        }
        Spacer(modifier = Modifier.padding(20.dp))

        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){


            TextField(
                modifier = Modifier.width(170.dp),
                value = call,
                onValueChange = { call = it },
                placeholder = { Text(text = "Call") }

            )

            Spacer(modifier = Modifier.padding())

            TextField(
                modifier = Modifier.width(170.dp),
                value = ownerName,
                onValueChange = { ownerName = it },
                placeholder = { Text(text = "OwnerName") }

            )



        }

        Spacer(modifier = Modifier.padding(20.dp))


        Spacer(modifier = Modifier.padding(20.dp))



        TextField(
            modifier = Modifier.width(350.dp),
            value = description,
            onValueChange = {description = it},
            placeholder = { Text(text = "description") }

        )




        Spacer(modifier = Modifier.padding(40.dp))

        Button(
            modifier = Modifier.width(250.dp),
            onClick = {
                val formData = imageUri?.toString()
                    ?.let { EquipmentModel(title,description,price,address,imageUri,call,ownerName) }
                equipmentViewModel.submitForm(formData!!)
                Toast.makeText(context,"Data Successfully added", Toast.LENGTH_SHORT).show()
                navHostController.navigate(Routes.listequipment)
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