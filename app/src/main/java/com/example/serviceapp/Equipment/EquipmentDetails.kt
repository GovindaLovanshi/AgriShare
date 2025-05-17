package com.example.serviceapp.Equipment

import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.serviceapp.Equipment.Model.EquipmentModel
import com.example.serviceapp.Equipment.Viewmodel.EquipmentViewModel
import com.example.serviceapp.LanourJob.JObDetails

import com.example.serviceapp.LanourJob.TopBarJob
import com.example.serviceapp.R
import com.example.serviceapp.navigation.Routes


@Composable
fun EquipmentDetails(navHostController: NavHostController){

    val EqupmentViewModel : EquipmentViewModel = viewModel()
    val formDataList = EqupmentViewModel.equpmentDataList
    val context = LocalContext.current
    LaunchedEffect(true) {
        EqupmentViewModel.getFormData()
    }


    Scaffold(
        topBar = {
            TopBarEqup()
        },
        bottomBar = {

        }

    ) {padding ->

        LazyColumn (modifier = Modifier.padding(padding)){

            items(formDataList) { data->
                listEquipement(data , onClick = {
                    navHostController.navigate(Routes.listequipment)
                },navHostController)

            }
        }
    }
}
@Composable
fun listEquipement(
    equpmentModel:EquipmentModel,
    onClick :()->Unit,
    navHostController: NavHostController
){

    val EqupmentViewModel : EquipmentViewModel = viewModel()
    val formDataList = EqupmentViewModel.equpmentDataList
    val context = LocalContext.current
    LaunchedEffect(true) {
        EqupmentViewModel.getFormData()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {


        Image(
            painter = painterResource(R.drawable.road),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
                .background(
                    colorResource(R.color.lightGrey),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = equpmentModel.title,
                fontSize = 23.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(end = 16.dp)
            )
            Text(
                text = equpmentModel.price,
                fontSize = 22.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = "Previous Booking",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.fav_icon),
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = " Rating", style = MaterialTheme.typography.bodyMedium)

        }


        Spacer(modifier = Modifier.height(12.dp))


        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = equpmentModel.call,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.location), contentDescription = null)
                Text(
                    text = equpmentModel.ownerName,
                    color = Color.Black,
                    fontSize = 12.sp,
                    maxLines = 1,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }


            Spacer(modifier = Modifier.height(12.dp))


            Text(
                text = equpmentModel.description,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1
            )

            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))



            Spacer(modifier = Modifier.height(150.dp))
            HorizontalDivider()
            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                ,
                onClick = {
                    val phoneNumber="tel:"+equpmentModel.call
                    val diaIntent= Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
                    context.startActivity(diaIntent)
                },
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
    }
}
//
//@Composable
//fun RatingBar(rating: Double) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.padding(top = 16.dp)
//    ) {
//        Text(
//            text = "Select Model",
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.weight(1f)
//        )
//        Image(
//            painter = painterResource(id = R.drawable.fav_icon),
//            contentDescription = null,
//            modifier = Modifier.padding(end = 8.dp)
//        )
//        Text(text = "$rating Rating", style = MaterialTheme.typography.bodyMedium)
//
//    }
//}